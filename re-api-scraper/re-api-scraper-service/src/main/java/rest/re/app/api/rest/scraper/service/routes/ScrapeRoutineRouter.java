package rest.re.app.api.rest.scraper.service.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.scraper.service.routes.directs.Nameable;
import rest.re.app.api.rest.scraper.service.utils.TimeInMillisecondsInterpreter;

@Component
public class ScrapeRoutineRouter extends RouteBuilder {
    @Value("${scraper.interval:24h}")
    private String interval;

    @Autowired
    private Nameable scrapeCharacterListRouter;

    @Override
    public void configure() throws Exception {

        final Integer scraperInterval = interpretIntervalValue(interval);

        from(String.format("timer:scrape-characters?period=%s&delay=0", scraperInterval))
                .to(scrapeCharacterListRouter.directName());
    }

    private Integer interpretIntervalValue(String interval) {
        // Expected regex: ^[0-9]+[s|m|h]$
        if(interval.matches("^[0-9]+[s|m|h|d]$")){
            final Integer lastIndex = interval.length()-1;
            final String numberPortion = interval.substring(0, lastIndex);
            final Character unitPortion = interval.charAt(lastIndex);
            return TimeInMillisecondsInterpreter.of(numberPortion, unitPortion).interpret();
        }else{
            // Return default
            return TimeInMillisecondsInterpreter.of("24", 'h').interpret();
        }
    }
}

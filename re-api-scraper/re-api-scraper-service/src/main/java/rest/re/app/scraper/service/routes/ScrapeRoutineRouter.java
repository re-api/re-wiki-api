package rest.re.app.scraper.service.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.re.app.scraper.service.routes.directs.Nameable;

@Component
public class ScrapeRoutineRouter extends RouteBuilder {

    @Autowired
    private Nameable scrapeCharacterListRouter;

    @Override
    public void configure() throws Exception {
        from("timer:scrape-characters?period=10000&delay=0")
                .to(scrapeCharacterListRouter.directName());
    }
}

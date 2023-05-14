package rest.re.app.api.rest.scraper.service.routes.directs;

import common.lib.models.serializable.GameCharacter;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.scraper.service.exchangeproperties.ExchangeProp;
import rest.re.app.api.rest.scraper.service.beanprocessors.Preparer;

import java.util.Iterator;
import java.util.List;

@Component
public class ScrapeCharacterListRouter extends RouteBuilder implements Nameable {

    @Autowired
    private Preparer listOfGameCharacterPreparerBean;

    @Autowired
    private ExchangeProp<Iterator<GameCharacter>> gameCharactersIteratorExchangeProp;
    @Autowired
    private ExchangeProp<List<GameCharacter>> listOfGameCharactersExchangeProp;

    @Autowired
    private Nameable activeMqGameCharacterPrepareRouter;

    @Override
    public void configure() throws Exception {

        from("direct:scrape-character-list")
                .bean(listOfGameCharacterPreparerBean, "prepare")
                .loopDoWhile(exchange-> gameCharactersIteratorExchangeProp.retrieveFrom(exchange).hasNext())
                .to(activeMqGameCharacterPrepareRouter.directName());
    }

    @Override
    public String name() {
        return "scrape-character-list";
    }

    @Override
    public String directName() {
        return String.format("direct:%s", name());
    }
}

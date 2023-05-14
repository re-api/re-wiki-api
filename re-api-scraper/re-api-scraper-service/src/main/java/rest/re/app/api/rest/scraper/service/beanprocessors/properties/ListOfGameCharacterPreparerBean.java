package rest.re.app.api.rest.scraper.service.beanprocessors.properties;

import common.lib.models.serializable.GameCharacter;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepInput;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepOutput;
import flow.steps.charactersfetchingstep.impl.ScraperCharactersFetchingStepImpl;
import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepInput;
import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepOutput;
import flow.steps.listgameurlfetchingstepimpl.ListGameUrlFetchingStepImpl;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.scraper.service.beanprocessors.Preparer;
import rest.re.app.api.rest.scraper.service.exchangeproperties.ExchangeProp;

import java.util.Iterator;
import java.util.List;

@Component
public class ListOfGameCharacterPreparerBean implements Preparer {

    final Logger logger = LoggerFactory.getLogger(ListOfGameCharacterPreparerBean.class);

    @Autowired
    private ExchangeProp<List<String>> listOfGameUrlsExchangeProp;
    @Autowired
    private ExchangeProp<List<GameCharacter>> listOfGameCharactersExchangeProp;
    @Autowired
    private ExchangeProp<Iterator<GameCharacter>> gameCharactersIteratorExchangeProp;

    /**
     * Prepares the following exchange properties:
     * - listOfGamesUrl
     * - listOfGameCharacters
     * - gameCharactersIterator
     * @param exchange
     */
    @Override
    public void prepare(final Exchange exchange) {

        ScraperCharactersFetchingStepImpl scraperCharactersFetchingStepImpl = new ScraperCharactersFetchingStepImpl();
        ListGameUrlFetchingStepImpl listGameUrlFetchingStepImpl = new ListGameUrlFetchingStepImpl();

        listGameUrlFetchingStepImpl
                .execute(new ListGameUrlFetchingStepInput()
                        .setResidentEvilGamesUrlPath("wiki/Resident_Evil_games#Major_releases"))
                .map(ListGameUrlFetchingStepOutput::getListOfGamesUrl)
                .map(listOfGamesUrl->{
                    listOfGameUrlsExchangeProp.saveTo(exchange, listOfGamesUrl);
                    return listOfGamesUrl;
                })
                .flatMap(listOfGamesUrl->scraperCharactersFetchingStepImpl
                        .execute(new ScraperCharactersFetchingStepInput().setGamesUrlPath(listOfGamesUrl)))
                .map(ScraperCharactersFetchingStepOutput::getListOfScrapedGameCharacters)
                .map(listOfGameCharacters->{
                    listOfGameCharactersExchangeProp.saveTo(exchange, listOfGameCharacters);
                    return listOfGameCharacters;
                })
                .map(listOfGameCharacters->{
                    gameCharactersIteratorExchangeProp.saveTo(exchange, listOfGameCharacters.iterator());
                    return listOfGameCharacters;
                })
                .doOnError(error-> logger.error("An error occurred while trying to scrape the list of characters. Here are the " +
                        "error details: {}", error.getMessage()))
                .subscribe(listOfGameCharacters-> logger.debug("listOfScrapedGameCharacters: {}", listOfGameCharacters))
                .dispose();
    }


}

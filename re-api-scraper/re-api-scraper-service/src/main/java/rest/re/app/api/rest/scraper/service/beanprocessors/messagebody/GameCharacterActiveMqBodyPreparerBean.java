package rest.re.app.api.rest.scraper.service.beanprocessors.messagebody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.api.model.GameCharacter;
import rest.re.app.api.rest.scraper.service.beanprocessors.Preparer;
import rest.re.app.api.rest.scraper.service.exchangeproperties.ExchangeProp;

import java.util.Iterator;
import java.util.Optional;


@Component
public class GameCharacterActiveMqBodyPreparerBean implements Preparer {

    final Logger logger = LoggerFactory.getLogger(GameCharacterActiveMqBodyPreparerBean.class);

    @Autowired
    private ExchangeProp<Iterator<GameCharacter>> gameCharactersIteratorExchangeProp;

    @Override
    public void prepare(final Exchange exchange) {
        Optional.of(gameCharactersIteratorExchangeProp.retrieveFrom(exchange))
                .ifPresent(iterator->{

                    try {
                        final GameCharacter gameCharacter = iterator.next();
                        // turn it into JSON and update message body.
                        ObjectMapper objectMapper = new ObjectMapper();
                        final String jsonCharacter;
                        jsonCharacter = objectMapper.writeValueAsString(gameCharacter);
                        logger.debug("Successfully turned gameCharacter {} into a json: {}", gameCharacter, jsonCharacter);

                        exchange.getMessage().setBody(jsonCharacter);

                    } catch (JsonProcessingException e) {
                        logger.error("Exception thrown when trying to serialize the game character. Processor is going to throw. " +
                                        "Error: {}", e.getMessage());
                        throw new RuntimeException();
                    }
                });
    }
}

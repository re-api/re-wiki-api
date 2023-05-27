package rest.re.app.api.rest.scraper.service.exchangeproperties;


import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.api.model.GameCharacter;

import java.util.List;
import java.util.Optional;

@Component
public class ListOfGameCharactersExchangeProp implements ExchangeProp<List<GameCharacter>> {
    @Override
    public void saveTo(final Exchange exchange, final List<GameCharacter> listOfGamesCharacters) {
        Optional.of(exchange).ifPresent(ex->ex.setProperty(prop(), listOfGamesCharacters));
    }

    @Override
    public List<GameCharacter> retrieveFrom(Exchange exchange) {
        return (List<GameCharacter>) Optional.ofNullable(exchange)
                .map(ex -> ex.getProperty(prop(), (List.class))).orElse(null);
    }

    @Override
    public String prop() {
        return "listOfGameCharacters";
    }
}

package rest.re.app.scraper.service.exchangeproperties;

import common.lib.models.serializable.GameCharacter;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Optional;

@Component
public class GameCharactersIteratorExchangeProp implements ExchangeProp<Iterator<GameCharacter>> {
    @Override
    public void saveTo(final Exchange exchange, final Iterator<GameCharacter> gameCharacterIterator) {
        Optional.of(exchange).ifPresent(ex->ex.setProperty(prop(), gameCharacterIterator));
    }

    @Override
    public Iterator<GameCharacter> retrieveFrom(final Exchange exchange) {
        return Optional.ofNullable(exchange)
                .map(ex -> ex.getProperty(prop(), (Iterator.class))).orElse(null);
    }

    @Override
    public String prop() {
        return "gameCharactersIterator";
    }
}

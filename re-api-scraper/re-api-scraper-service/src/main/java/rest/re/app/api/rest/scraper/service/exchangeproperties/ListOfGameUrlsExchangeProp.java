package rest.re.app.api.rest.scraper.service.exchangeproperties;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Saves
 */
@Component
public class ListOfGameUrlsExchangeProp implements ExchangeProp<List<String>>{

    /**
     * Saves property into exchange
     * @param exchange the camel exchange
     * @param listOfGamesUrl the property to save.
     */
    @Override
    public void saveTo(final Exchange exchange, final List<String> listOfGamesUrl) {
        Optional.of(exchange).ifPresent(ex->ex.setProperty(prop(), listOfGamesUrl));
    }

    /**
     * Retrieves the prop from the exchange.
     * @param exchange the camel exchange
     * @return the property to save.
     */
    @Override
    public List<String> retrieveFrom(final Exchange exchange) {
        return (List<String>) Optional.ofNullable(exchange)
                .map(ex -> ex.getProperty(prop(), (List.class))).orElse(null);
    }

    // Hardcoding the property name.
    @Override
    public String prop() {
        return "listOfGameUrls";
    }
}

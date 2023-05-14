package rest.re.app.api.rest.scraper.service.exchangeproperties;

import org.apache.camel.Exchange;

public interface ExchangeProp <T>{

    void saveTo(final Exchange exchange, final T prop);

    T retrieveFrom(final Exchange exchange);

    String prop();
}

package rest.re.app.api.rest.scraper.service.beanprocessors;

import org.apache.camel.Exchange;

public interface Preparer {

    void prepare(Exchange exchange);
}

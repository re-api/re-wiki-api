package rest.re.app.scraper.service.beanprocessors;

import org.apache.camel.Exchange;

public interface Preparer {

    void prepare(Exchange exchange);
}

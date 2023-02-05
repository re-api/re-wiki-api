package rest.re.app.scraper.service.routes.directs;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import rest.re.app.scraper.service.beanprocessors.Preparer;

@Component
public class ActiveMqGameCharacterPrepareRouter extends RouteBuilder implements Nameable{

    @Autowired
    private Preparer gameCharacterActiveMqBodyPreparerBean;
    @Override
    public void configure() throws Exception {

        from(directName())
                .bean(gameCharacterActiveMqBodyPreparerBean, "prepare")
                .to("activemq:game-characters");
    }

    @Override
    public String name() {
        return "active-mq-game-character-prepare";
    }

    @Override
    public String directName() {
        return String.format("direct:%s", name());
    }
}

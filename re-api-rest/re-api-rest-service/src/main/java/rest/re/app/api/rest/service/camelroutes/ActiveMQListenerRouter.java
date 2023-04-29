package rest.re.app.api.rest.service.camelroutes;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
import re.api.common.lib.QueueNames;


@Component
@Slf4j
public class ActiveMQListenerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {




        from(QueueNames.GAME_CHARACTERS.retrieveActiveMqRouteUri()).routeId(QueueNames.GAME_CHARACTERS.retrieveActiveMqRouteUri())
                .log(LoggingLevel.DEBUG, "Message Received from ActiveMQ")
                .process(exchange -> {
                    log.info("Message Received: " + exchange.getMessage().getBody().toString());
                });

    }
}

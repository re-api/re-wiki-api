package rest.re.app.scraper.service;

import lombok.Getter;
import rest.re.app.scraper.service.RouteUriRetrievable;

@Getter
public enum QueueNames implements RouteUriRetrievable {

    GAME_CHARACTERS("game-characters"),
    GAMES("games"),
    ITEMS("items");

    private final String queueName;

    QueueNames(final String queueName) {
        this.queueName = queueName;
    }

    @Override
    public String retrieveActiveMqRouteUri(){
        return String.format("activemq:%s", queueName);
    }

}

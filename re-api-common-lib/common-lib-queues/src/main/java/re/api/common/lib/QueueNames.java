package re.api.common.lib;

import lombok.Getter;

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

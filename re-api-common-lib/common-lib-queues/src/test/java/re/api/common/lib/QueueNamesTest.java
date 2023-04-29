package re.api.common.lib;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class QueueNamesTest {
    @Test
    void whenGameCharactersThenActiveMQRouteIdShouldStartWithActiveMQTextFollowedByGameCharacterText(){
        // when
        final RouteUriRetrievable queueName = QueueNames.GAME_CHARACTERS;

        // When
        final String queueRouteId = queueName.retrieveActiveMqRouteUri();

        // Then
        Assertions.assertEquals("activemq:game-characters", queueRouteId);
    }

    @Test
    void whenGamesThenActiveMQRouteIdShouldStartWithActiveMQTextFollowedByGamesText(){
        // when
        final RouteUriRetrievable queueName = QueueNames.GAMES;

        // When
        final String queueRouteId = queueName.retrieveActiveMqRouteUri();

        // Then
        Assertions.assertEquals("activemq:games", queueRouteId);
    }

    @Test
    void whenItemsThenActiveMQRouteIdShouldStartWithActiveMQTextFollowedByItemsText(){
        // when
        final RouteUriRetrievable queueName = QueueNames.ITEMS;

        // When
        final String queueRouteId = queueName.retrieveActiveMqRouteUri();

        // Then
        Assertions.assertEquals("activemq:items", queueRouteId);
    }
}
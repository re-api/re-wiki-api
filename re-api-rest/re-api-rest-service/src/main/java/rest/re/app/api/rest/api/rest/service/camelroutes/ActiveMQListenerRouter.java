package rest.re.app.api.rest.api.rest.service.camelroutes;

import com.fasterxml.jackson.databind.ObjectMapper;
import common.lib.models.serializable.GameCharacter;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import re.api.common.lib.CRUDService;
import re.api.common.lib.QueueNames;

import rest.re.app.api.rest.api.rest.service.models.CharacterServiceCharacter;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Component
public class ActiveMQListenerRouter extends RouteBuilder {


    private static final Logger logger = LoggerFactory.getLogger(ActiveMQListenerRouter.class);

    @Autowired
    private CRUDService<CharacterServiceCharacter> characterService;

    private static final String CHARACTER_PROP = "character";

    @Override
    public void configure() throws Exception {

        from(QueueNames.GAME_CHARACTERS.retrieveActiveMqRouteUri()).routeId(QueueNames.GAME_CHARACTERS.retrieveActiveMqRouteUri())
                .log(LoggingLevel.DEBUG, "Message Received from ActiveMQ")
                .process(exchange -> {
                    logger.info("Message Received: {}", exchange.getMessage().getBody());
                    final GameCharacter gameCharacter = new ObjectMapper().readValue(exchange.getMessage().getBody()
                            .toString(), GameCharacter.class);

                    logger.info("Message after turning JSON into GameCharacter: {}", gameCharacter);
                    exchange.getMessage().setBody(gameCharacter);
                })
                .process(exchange -> {
                    logger.info("Converting received game character into characterServiceCharacter");
                    try {

                        final GameCharacter gameCharacter = exchange.getMessage().getBody(GameCharacter.class);

                        final UUID uuid = UUID.randomUUID();

                        logger.debug("Creating a new ID to character: {}", uuid);
                        final CharacterServiceCharacter characterServiceCharacter = new CharacterServiceCharacter()
                                .setId(uuid)
                                .setName(gameCharacter.getName())
                                .setLocalization(gameCharacter.getLocalization())
                                .setDescription(gameCharacter.getDescription())
                                .setDateOfBirth(gameCharacter.getDateOfBirth())
                                .setDateOfDeath(gameCharacter.getDateOfDeath())
                                .setPlaceOfBirth(gameCharacter.getPlaceOfBirth())
                                .setPlaceOfDeath(gameCharacter.getPlaceOfDeath())
                                .setRace(gameCharacter.getRace())
                                .setOccupation(gameCharacter.getOccupation())
                                .setStatus(gameCharacter.getStatus())
                                .setSex(gameCharacter.getSex())
                                .setBloodType(gameCharacter.getBloodType())
                                .setHeight(Integer.valueOf(Optional.ofNullable(gameCharacter.getHeight())
                                        .map(height->height.getCentimeters()).orElse(null)))
                                .setBodyMass(Double.valueOf(Optional.ofNullable(gameCharacter.getBodyMass())
                                        .map(bodyMass -> bodyMass.getKilogram()).orElse(null)))
                                .setFirstAppearance(gameCharacter.getFirstAppearance())
                                .setLastAppearance(gameCharacter.getLastAppearance());

                        logger.trace("Character to be saved to the database: {}", characterServiceCharacter);

                        exchange.setProperty(CHARACTER_PROP, characterServiceCharacter);

                    } catch (Exception e) {
                        logger.error("An error occurred while converting the scraped game character into a " +
                                "characterServiceCharacterModel. Error: {}", e.toString());

                    }
                })
                .process(exchange -> {
                    try{
                        final CharacterServiceCharacter characterServiceCharacter = exchange.getProperty(CHARACTER_PROP,
                                CharacterServiceCharacter.class);
                        if(Objects.nonNull(characterServiceCharacter)){
                            logger.info("Saving the character to the database.");
                            characterService.save(characterServiceCharacter);
                        }
                    }catch (Exception e){
                        logger.error("Error saving the character to database: {}", e.toString());
                    }
                });

    }
}

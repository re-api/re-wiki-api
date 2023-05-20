package rest.re.app.api.rest.api.rest.service.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import re.api.common.lib.CRUDService;
import re.api.common.lib.parsers.BodyMassFromDoubleParser;
import re.api.common.lib.parsers.HeightFromIntegerParser;
import rest.re.app.api.rest.api.CharactersApi;
import rest.re.app.api.rest.api.model.GameCharacter;
import rest.re.app.api.rest.api.rest.service.models.CharacterServiceCharacter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CharactersController implements CharactersApi {

    Logger logger = LoggerFactory.getLogger(CharactersController.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private CRUDService<CharacterServiceCharacter> characterService;


    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.of(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }


    @Override
    public ResponseEntity<List<GameCharacter>> findCharacters() {
        logger.info("Starting the CharactersController::findCharacters operation.");
        List<GameCharacter> gameCharacters = new ArrayList<>();

        Single.fromCallable(() -> characterService.listAll())
                .map(characterServiceCharacters -> {
                    final List<GameCharacter> gCharacters = characterServiceCharacters.stream()
                            .map(characterServiceCharacter -> {
                                final GameCharacter apiResponseGameCharacter = new GameCharacter();
                                apiResponseGameCharacter.setId(characterServiceCharacter.getId());
                                apiResponseGameCharacter.setName(characterServiceCharacter.getName());
                                apiResponseGameCharacter.setDescription(characterServiceCharacter.getDescription());
                                apiResponseGameCharacter.setDateOfBirth(characterServiceCharacter.getDateOfBirth());
                                apiResponseGameCharacter.setDateOfDeath(characterServiceCharacter.getDateOfDeath());
                                apiResponseGameCharacter.setPlaceOfBirth(characterServiceCharacter.getPlaceOfBirth());
                                apiResponseGameCharacter.setPlaceOfDeath(characterServiceCharacter.getPlaceOfDeath());
                                apiResponseGameCharacter.setSex(safeParseSex(characterServiceCharacter.getSex()));
                                apiResponseGameCharacter.setHeight(new HeightFromIntegerParser().parse(String.valueOf(characterServiceCharacter.getHeight())));
                                apiResponseGameCharacter.setBodyMass(new BodyMassFromDoubleParser().parse(String.valueOf(characterServiceCharacter.getBodyMass())));
                                apiResponseGameCharacter.setFirstAppearance(characterServiceCharacter.getFirstAppearance());
                                apiResponseGameCharacter.setLastAppearance(characterServiceCharacter.getLastAppearance());
                                apiResponseGameCharacter.setBloodType(characterServiceCharacter.getBloodType());
                                apiResponseGameCharacter.setOccupation(characterServiceCharacter.getOccupations());
                                apiResponseGameCharacter.setRace(characterServiceCharacter.getRace());
                                apiResponseGameCharacter.setStatus(parseSafeStatus(characterServiceCharacter.getStatus()));
                                apiResponseGameCharacter.setLocalization(characterServiceCharacter.getLocalization());

                                // Add to the outter gameCharacters array:
                                gameCharacters.add(apiResponseGameCharacter);

                                return apiResponseGameCharacter;
                            }).collect(Collectors.toList());
                    return gCharacters;
                })
                .doOnError(e -> {
                    logger.error("An error occurred while trying to generate API response {}", e.toString());
                })
                .subscribe(apiResponseGameCharacter -> {
                    logger.trace("CharactersController::findCharacters operation. Value returned: {}", apiResponseGameCharacter);
                });
        return ResponseEntity.ok(gameCharacters);
    }

    private GameCharacter.StatusEnum parseSafeStatus(String status) {
        //@TODO: import re-api into scraper so that the enums can be used to generate the message.
        return Optional.ofNullable(status)
                .map(s -> {
                    try {
                        return GameCharacter.StatusEnum.valueOf(s);
                    } catch (Exception e) {
                        logger.error("An error occurred while trying to parse status {}", e.toString());
                        return null;
                    }
                })
                .orElse(null);
    }

    private GameCharacter.SexEnum safeParseSex(String sex) {
        return Optional.ofNullable(sex)
                .map(s -> {
                    try {
                        return GameCharacter.SexEnum.valueOf(s);
                    } catch (Exception e) {
                        logger.error("An error occurred while trying to parse sex {}", e.toString());
                        return null;
                    }
                })
                .orElse(null);
    }
}

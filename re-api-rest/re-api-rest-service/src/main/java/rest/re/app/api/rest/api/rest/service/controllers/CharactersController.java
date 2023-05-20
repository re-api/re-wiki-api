package rest.re.app.api.rest.api.rest.service.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import rest.re.app.api.rest.api.CharactersApi;
import rest.re.app.api.rest.api.model.GameCharacter;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CharactersController implements CharactersApi {

    private final ObjectMapper objectMapper = new ObjectMapper();


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
        final List<GameCharacter> gameCharacters = new ArrayList<>();
        gameCharacters.add(new GameCharacter());
        return ResponseEntity.ok(gameCharacters);
    }
}

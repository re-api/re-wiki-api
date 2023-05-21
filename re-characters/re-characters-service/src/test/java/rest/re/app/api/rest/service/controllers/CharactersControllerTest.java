package rest.re.app.api.rest.service.controllers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.re.app.api.rest.api.model.GameCharacter;

class CharactersControllerTest {

    @Test
    void whenMaleThenSafeSexEnumParserShouldReturnMale(){
        // Given string Male
        final String male = "Male";

        final GameCharacter.SexEnum sexEnum = GameCharacter.SexEnum.fromValue(male);

        Assertions.assertEquals(GameCharacter.SexEnum.MALE, sexEnum);

    }

    @Test
    void whenFemaleThenSafeSexEnumParserShouldReturnMale(){
        // Given string Male
        final String female = "Female";

        final GameCharacter.SexEnum sexEnum = GameCharacter.SexEnum.fromValue(female);

        Assertions.assertEquals(GameCharacter.SexEnum.FEMALE, sexEnum);

    }

    @Test
    void whenMaleIntersexThenSafeSexEnumParserShouldReturnMaleIntersex(){
        // Given string Male
        final String male = "Intersex (Male-identifying)";

        final GameCharacter.SexEnum sexEnum = GameCharacter.SexEnum.fromValue(male);

        Assertions.assertEquals(GameCharacter.SexEnum.INTERSEX_MALE_IDENTIFYING_, sexEnum);

    }
}
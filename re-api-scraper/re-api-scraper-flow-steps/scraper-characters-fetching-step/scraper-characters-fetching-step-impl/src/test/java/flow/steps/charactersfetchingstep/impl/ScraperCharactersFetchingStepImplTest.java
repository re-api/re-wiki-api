package flow.steps.charactersfetchingstep.impl;


import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepInput;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepOutput;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import re.api.common.lib.parsers.BodyMassFromDoubleParser;
import re.api.common.lib.parsers.HeightFromIntegerParser;
import re.api.common.lib.parsers.ScrapedBodyMassParser;
import re.api.common.lib.parsers.ScrapedHeightParser;
import rest.re.app.api.rest.api.model.GameCharacter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ScraperCharactersFetchingStepImplTest {

    @Test
    void checkingTheCharactersFetchingStepImplWithAListOf3GameUrls(){
        // Given a list of 3 character wiki urls:
        List<String> listOfWikiGames = Arrays.asList(
            "/wiki/Resident_Evil_(1996)",
            "/wiki/Resident_Evil_2_(1998)",
            "/wiki/Resident_Evil_3:_Nemesis"
        );

        // And one of the expected characters is:
        GameCharacter leon = new GameCharacter();
        leon.setName("Leon Scott Kennedy");
        leon.setDescription("Leon Scott Kennedy is an American of Italian descent currently employed as a federal agent by the Division of Security Operations (D.S.O.), a counter-terrorism agency with direct Presidential oversight. Kennedy is a known survivor of the 1998 Raccoon City Destruction Incident, then as a police officer. Following his escape, he was offered a job in a USSTRATCOM team devoted to anti-B.O.W. combat, and served it until 2011 in repeated operations around the world.");
        leon.setDateOfBirth("1977");
        leon.setRace("Caucasian/American");
        leon.setOccupation(Arrays.asList("Police Officer (1998)", "USSTRATCOM Agent (1998–2011)", "DSO Agent (2011–)"));
        leon.setStatus(GameCharacter.StatusEnum.fromValue("Alive"));
        leon.setSex(GameCharacter.SexEnum.fromValue("Male"));
        leon.setBloodType("A");
        leon.setHeight(new HeightFromIntegerParser().parse(new ScrapedHeightParser().parse("178 cm (5 ft 10 in) 180 cm (5 ft 11 in)").getCentimeters()));
        leon.setBodyMass(new BodyMassFromDoubleParser().parse(new ScrapedBodyMassParser().parse("70.2 kg (155 lb) 75 kg (165 lb)").getKilogram()));
        leon.setFirstAppearance("Resident Evil 2 (1998)");
        leon.setLastAppearance("Resident Evil: Death Island");

        // And another expected character is:
        GameCharacter nikolai = new GameCharacter();
        nikolai.setName("Nikolai Zinoviev Николай Зиновьев");
        nikolai.setLocalization("Nicholai Ginovaef");
        nikolai.setDescription("Nikolai Zinoviev (ニコライ・ジノビェフ, Nikorai Jinobyefu?, Russian: Николай Зиновьев), codenamed \"Silver Wolf\", is a Soviet Army veteran who served in Umbrella's paramilitary as a Sergeant in the UBCS as well as a Monitor. He and the USS commando, HUNK were considered to be \"rivals\", and he was a close friend of Col. Sergei Vladimir, of whom he may have served with in the Soviet Army.");
        nikolai.setPlaceOfBirth("Moscow, Russian SFSR, USSR");
        nikolai.setRace("Caucasian/Russian");
        nikolai.setOccupation(Collections.singletonList("UBCS Sergeant/Monitor"));
        nikolai.setStatus(GameCharacter.StatusEnum.fromValue("Unknown"));
        nikolai.setSex(GameCharacter.SexEnum.fromValue("Male"));
        nikolai.setBloodType("A");
        nikolai.setHeight(new HeightFromIntegerParser().parse(new ScrapedHeightParser().parse("187 cm (6 ft 2 in)").getCentimeters()));
        nikolai.setBodyMass(new BodyMassFromDoubleParser().parse(new ScrapedBodyMassParser().parse("102 kg (225 lb)").getKilogram()));
        nikolai.setFirstAppearance("Resident Evil 3: Nemesis");
        nikolai.setLastAppearance("Resident Evil: Resistance");

        // And Input containing this list:
        ScraperCharactersFetchingStepInput input = new ScraperCharactersFetchingStepInput()
                .setGamesUrlPath(listOfWikiGames);

        // When the flow step is executed:
        Single<ScraperCharactersFetchingStepOutput> singleOutput = new ScraperCharactersFetchingStepImpl().execute(input);

        List<GameCharacter> listOfScrapedGameCharacters = singleOutput.test().values().get(0)
                .getListOfScrapedGameCharacters();

        Assertions.assertTrue(listOfScrapedGameCharacters.stream()
                .anyMatch(scrapedGameCharacter->scrapedGameCharacter.equals(leon)));
        Assertions.assertTrue(listOfScrapedGameCharacters.stream()
                .anyMatch(scrapedGameCharacter->scrapedGameCharacter.equals(nikolai)));

    }

}
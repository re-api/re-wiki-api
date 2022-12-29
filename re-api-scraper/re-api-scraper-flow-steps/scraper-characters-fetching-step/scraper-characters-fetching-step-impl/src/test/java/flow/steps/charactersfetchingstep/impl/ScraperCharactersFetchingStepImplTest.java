package flow.steps.charactersfetchingstep.impl;

import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepInput;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepOutput;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.re.app.scraper.converter.models.ScrapedGameCharacter;

import java.util.Arrays;
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
        ScrapedGameCharacter leon = new ScrapedGameCharacter()
                .setName("Leon Scott Kennedy")
                .setDescription("Leon Scott Kennedy is an American of Italian descent currently employed as a federal agent by the Division of Security Operations (D.S.O.), a counter-terrorism agency with direct Presidential oversight. Kennedy is a known survivor of the 1998 Raccoon City Destruction Incident, then as a police officer. Following his escape, he was offered a job in a US.STRATCOM team devoted to anti-B.O.W. combat, and served it until 2011 in repeated operations around the world.")
                .setDateOfBirth("1977")
                .setRace("Caucasian/American")
                .setOccupation("Police Officer (1998) US-STRATCOM Agent (1998–2011) DSO Agent (2011–)")
                .setStatus("Alive")
                .setSex("Male")
                .setBloodType("A")
                .setHeight("178 cm (5 ft 10 in) 180 cm (5 ft 11 in)")
                .setBodyMass("70.2 kg (155 lb) 75 kg (165 lb)")
                .setFirstAppearance("Resident Evil 2 (1998)")
                .setLastAppearance("Resident Evil 4 (2023)");

        // And another expected character is:
        ScrapedGameCharacter nikolai = new ScrapedGameCharacter()
                .setName("Nikolai Zinoviev Николай Зиновьев")
                .setLocalization("Nicholai Ginovaef")
                .setDescription("Nikolai Zinoviev (ニコライ・ジノビェフ, Nikorai Jinobyefu?, Russian: Николай Зиновьев), codenamed \"Silver Wolf\", is a Soviet Army veteran who served in Umbrella's paramilitary as a Sergeant in the UBCS as well as a Monitor. He and the USS commando, HUNK were considered to be \"rivals\", and he was a close friend of Col. Sergei Vladimir, of whom he may have served with in the Soviet Army.")
                .setPlaceOfBirth("Moscow, Russian SFSR, USSR")
                .setRace("Caucasian/Russian")
                .setOccupation("UBCS Sergeant/Monitor")
                .setStatus("Unknown")
                .setSex("Male")
                .setBloodType("A")
                .setHeight("187 cm (6 ft 2 in)")
                .setBodyMass("102 kg (225 lb)")
                .setFirstAppearance("Resident Evil 3: Nemesis")
                .setLastAppearance("Resident Evil: Resistance");

        // And Input containing this list:
        ScraperCharactersFetchingStepInput input = new ScraperCharactersFetchingStepInput()
                .setGamesUrlPath(listOfWikiGames);

        // When the flow step is executed:
        Single<ScraperCharactersFetchingStepOutput> singleOutput = new ScraperCharactersFetchingStepImpl().execute(input);

        List<ScrapedGameCharacter> listOfScrapedGameCharacters = singleOutput.test().values().get(0)
                .getListOfScrapedGameCharacters();

        Assertions.assertTrue(listOfScrapedGameCharacters.stream()
                .anyMatch(scrapedGameCharacter->scrapedGameCharacter.equals(leon)));
        Assertions.assertTrue(listOfScrapedGameCharacters.stream()
                .anyMatch(scrapedGameCharacter->scrapedGameCharacter.equals(nikolai)));

    }

}
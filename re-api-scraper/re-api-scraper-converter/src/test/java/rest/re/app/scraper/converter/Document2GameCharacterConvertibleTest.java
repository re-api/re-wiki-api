package rest.re.app.scraper.converter;

import common.lib.models.serializable.BodyMass;
import common.lib.models.serializable.GameCharacter;
import io.reactivex.rxjava3.core.Single;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.re.app.scraper.converter.parsers.HeightParser;
import rest.re.app.scraper.wiki.ReScrapedWikiPage;

import java.util.Arrays;
import java.util.Collections;

class Document2GameCharacterConvertibleTest {

    @Test
    void convertingLeonsHtmlContentIntoGameCharacterSchema(){
        // Given Leon's HTML content:
        Single<Document> documentSingle = ReScrapedWikiPage.of("/wiki/Leon_Scott_Kennedy").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter()
                .setName("Leon Scott Kennedy")
                .setDescription("Leon Scott Kennedy is an American of Italian descent currently employed as a federal agent by the Division of Security Operations (D.S.O.), a counter-terrorism agency with direct Presidential oversight. Kennedy is a known survivor of the 1998 Raccoon City Destruction Incident, then as a police officer. Following his escape, he was offered a job in a US.STRATCOM team devoted to anti-B.O.W. combat, and served it until 2011 in repeated operations around the world.")
                .setDateOfBirth("1977")
                .setRace("Caucasian/American")
                .setOccupation(Arrays.asList("Police Officer (1998)", "US-STRATCOM Agent (1998–2011)", "DSO Agent (2011–)"))
                .setStatus("Alive")
                .setSex("Male")
                .setBloodType("A")
                .setHeight(new HeightParser().parse("178 cm"))
                .setBodyMass(new BodyMass().setKilogram("70.2").setPound("154.76"))
                .setFirstAppearance("Resident Evil 2 (1998)")
                .setLastAppearance("Resident Evil 4 (2023)");
        // document
        Document doc = documentSingle.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }

    @Test
    void convertingHenricosHtmlContentIntoGameCharacterSchema(){
        // Given Leon's HTML content:
        Single<Document> enricosPage = ReScrapedWikiPage.of("/wiki/Enrico_Marini").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter()
                .setName("Enrico Marini")
                .setDescription("Enrico Marini (エンリコ・マリーニ, Enriko Marīni?) was the Vice-Captain of the Special Tactics And Rescue Service under Captain Albert Wesker, and the team leader of the S.T.A.R.S. Bravo Team. A veteran known for his \"impervious\" mental strength, Marini was a competent and capable mission leader. He was of a clement nature and was well-respected by his subordinates. His hobby was golf.")
                .setDateOfDeath("24 July 1998")
                .setDateOfBirth("1957")
                .setRace("Caucasian/American")
                .setOccupation(Collections.singletonList("S.T.A.R.S. Bravo Team Captain"))
                .setStatus("Deceased")
                .setSex("Male")
                .setBloodType("O")
                .setHeight(new HeightParser().parse("190 cm"))
                .setBodyMass(new BodyMass().setKilogram("83").setPound("182.98"))
                .setFirstAppearance("Resident Evil (1996)")
                .setLastAppearance("Resident Evil 0");
        // document
        Document doc = enricosPage.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }

    @Test
    void testingAGameCharacterWithPlaceOfBirth(){
        // Given Leon's HTML content:
        Single<Document> nikolaisPage = ReScrapedWikiPage.of("/wiki/Nikolai_Zinoviev").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter()
                .setName("Nikolai Zinoviev Николай Зиновьев")
                .setLocalization("Nicholai Ginovaef")
                .setDescription("Nikolai Zinoviev (ニコライ・ジノビェフ, Nikorai Jinobyefu?, Russian: Николай Зиновьев), codenamed \"Silver Wolf\", is a Soviet Army veteran who served in Umbrella's paramilitary as a Sergeant in the UBCS as well as a Monitor. He and the USS commando, HUNK were considered to be \"rivals\", and he was a close friend of Col. Sergei Vladimir, of whom he may have served with in the Soviet Army.")
                .setPlaceOfBirth("Moscow, Russian SFSR, USSR")
                .setRace("Caucasian/Russian")
                .setOccupation(Collections.singletonList("UBCS Sergeant/Monitor"))
                .setStatus("Unknown")
                .setSex("Male")
                .setBloodType("A")
                .setHeight(new HeightParser().parse("187 cm"))
                .setBodyMass(new BodyMass().setKilogram("102").setPound("224.87"))
                .setFirstAppearance("Resident Evil 3: Nemesis")
                .setLastAppearance("Resident Evil: Resistance");
        // document
        Document doc = nikolaisPage.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }
}
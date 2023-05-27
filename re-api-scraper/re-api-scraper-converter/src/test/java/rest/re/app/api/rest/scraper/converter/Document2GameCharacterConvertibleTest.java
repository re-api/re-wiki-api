package rest.re.app.api.rest.scraper.converter;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import re.api.common.lib.parsers.ScrapedHeightParser;
import rest.re.app.api.rest.api.model.BodyMass;
import rest.re.app.api.rest.api.model.GameCharacter;
import rest.re.app.api.rest.scraper.wiki.ReScrapedWikiPage;

import java.util.Arrays;
import java.util.Collections;

class Document2GameCharacterConvertibleTest {

    @Test
    void convertingLeonsHtmlContentIntoGameCharacterSchema() {
        // Given Leon's HTML content:
        Single<Document> documentSingle = ReScrapedWikiPage.of("/wiki/Leon_Scott_Kennedy").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter();
        expectedCharacter.setName("Leon Scott Kennedy");
        expectedCharacter.setDescription("Leon Scott Kennedy is an American of Italian descent currently employed as a federal agent by the Division of Security Operations (D.S.O.), a counter-terrorism agency with direct Presidential oversight. Kennedy is a known survivor of the 1998 Raccoon City Destruction Incident, then as a police officer. Following his escape, he was offered a job in a USSTRATCOM team devoted to anti-B.O.W. combat, and served it until 2011 in repeated operations around the world.");
        expectedCharacter.setDateOfBirth("1977");
        expectedCharacter.setRace("Caucasian/American");
        expectedCharacter.setOccupation(Arrays.asList("Police Officer (1998)", "USSTRATCOM Agent (1998–2011)", "DSO Agent (2011–)"));
        expectedCharacter.setStatus(GameCharacter.StatusEnum.fromValue("Alive"));
        expectedCharacter.setSex(GameCharacter.SexEnum.fromValue("Male"));
        expectedCharacter.setBloodType("A");
        expectedCharacter.setHeight(new ScrapedHeightParser().parse("178 cm"));
        final BodyMass bodyMass = new BodyMass();
        bodyMass.setKilogram("70.2");
        bodyMass.setPound("154.76");

        expectedCharacter.setBodyMass(bodyMass);
        expectedCharacter.setFirstAppearance("Resident Evil 2 (1998)");
        expectedCharacter.setLastAppearance("Resident Evil: Death Island");
        // document
        Document doc = documentSingle.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }

    @Test
    void convertingHenricosHtmlContentIntoGameCharacterSchema() {
        // Given Leon's HTML content:
        Single<Document> enricosPage = ReScrapedWikiPage.of("/wiki/Enrico_Marini").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter();
        expectedCharacter.setName("Enrico Marini");
        expectedCharacter.setDescription("Enrico Marini (エンリコ・マリーニ, Enriko Marīni?) was the Vice-Captain of the Special Tactics And Rescue Service under Captain Albert Wesker, and the team leader of the S.T.A.R.S. Bravo Team. A veteran known for his \"impervious\" mental strength, Marini was a competent and capable mission leader. He was of a clement nature and was well-respected by his subordinates. His hobby was golf.");
        expectedCharacter.setDateOfDeath("24 July 1998");
        expectedCharacter.setDateOfBirth("1957");
        expectedCharacter.setRace("Caucasian/American");
        expectedCharacter.setOccupation(Collections.singletonList("S.T.A.R.S. Bravo Team Captain"));
        expectedCharacter.setStatus(GameCharacter.StatusEnum.fromValue("Deceased"));
        expectedCharacter.setSex(GameCharacter.SexEnum.fromValue("Male"));
        expectedCharacter.setBloodType("O");
        expectedCharacter.setHeight(new ScrapedHeightParser().parse("190 cm"));
        final BodyMass bodyMass = new BodyMass();
        bodyMass.setKilogram("83");
        bodyMass.setPound("182.98");
        expectedCharacter.setBodyMass(bodyMass);
        expectedCharacter.setFirstAppearance("Resident Evil (1996)");
        expectedCharacter.setLastAppearance("Resident Evil 0");
        // document
        Document doc = enricosPage.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }

    @Test
    void testingAGameCharacterWithPlaceOfBirth() {
        // Given Leon's HTML content:
        Single<Document> nikolaisPage = ReScrapedWikiPage.of("/wiki/Nikolai_Zinoviev").scrape();

        // Expected Result:
        GameCharacter expectedCharacter = new GameCharacter();
        expectedCharacter.setName("Nikolai Zinoviev Николай Зиновьев");
        expectedCharacter.setLocalization("Nicholai Ginovaef");
        expectedCharacter.setDescription("Nikolai Zinoviev (ニコライ・ジノビェフ, Nikorai Jinobyefu?, Russian: Николай Зиновьев), codenamed \"Silver Wolf\", is a Soviet Army veteran who served in Umbrella's paramilitary as a Sergeant in the UBCS as well as a Monitor. He and the USS commando, HUNK were considered to be \"rivals\", and he was a close friend of Col. Sergei Vladimir, of whom he may have served with in the Soviet Army.");
        expectedCharacter.setPlaceOfBirth("Moscow, Russian SFSR, USSR");
        expectedCharacter.setRace("Caucasian/Russian");
        expectedCharacter.setOccupation(Collections.singletonList("UBCS Sergeant/Monitor"));
        expectedCharacter.setStatus(GameCharacter.StatusEnum.fromValue("Unknown"));
        expectedCharacter.setSex(GameCharacter.SexEnum.fromValue("Male"));
        expectedCharacter.setBloodType("A");
        expectedCharacter.setHeight(new ScrapedHeightParser().parse("187 cm"));
        final BodyMass bodyMass = new BodyMass();
        bodyMass.setKilogram("102");
        bodyMass.setPound("224.87");
        expectedCharacter.setBodyMass(bodyMass);
        expectedCharacter.setFirstAppearance("Resident Evil 3: Nemesis");
        expectedCharacter.setLastAppearance("Resident Evil: Resistance");
        // document
        Document doc = nikolaisPage.test().values().get(0);

        //When
        GameCharacter resultingCharacter = new Document2GameCharacterConverter().convert(doc);

        Assertions.assertEquals(expectedCharacter, resultingCharacter);
    }
}
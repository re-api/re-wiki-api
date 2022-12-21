package rest.re.app.scraper.crawler;

import io.vavr.control.Either;
import models.GameCharacter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.re.app.scraper.crawler.models.ScrapedEntity;


class JillValentineScrapperTest {

    @Test
    void scrapeShouldFetchInformationAndReturnACharacterObject(){
        JillValentineScrapper jillValentineScrapper = new JillValentineScrapper();
        Either<Boolean, ScrapedEntity> actualCharacter = jillValentineScrapper.scrape("");

        GameCharacter gameCharacter = (GameCharacter) actualCharacter.get();

        Assertions.assertEquals(new GameCharacter("Jill Valentine"), gameCharacter);
    }
}
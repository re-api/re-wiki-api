package rest.re.app.scraper.crawler;

import io.vavr.control.Either;
import models.GameCharacter;
import org.jsoup.Jsoup;
import rest.re.app.scraper.crawler.models.ScrapedEntity;

import java.io.IOException;

public class JillValentineScrapper implements Scraper{

    private static final  String PATH = "Chris_Redfield";


    @Override
    public Either<Boolean, ScrapedEntity> scrape(String urlPath) {
        try {
            Jsoup.connect(Scraper.RESIDENT_WIKI_URL+"/"+PATH).userAgent("Mozilla").get();
            return Either.right(new GameCharacter("Jill Valentine"));
        } catch (IOException e) {

            return Either.left(false);
        }

    }


}

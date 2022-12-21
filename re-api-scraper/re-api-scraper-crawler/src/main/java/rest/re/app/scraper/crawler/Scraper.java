package rest.re.app.scraper.crawler;

import io.vavr.control.Either;
import rest.re.app.scraper.crawler.models.ScrapedEntity;

public interface Scraper {
    String RESIDENT_WIKI_URL = "https://residentevil.fandom.com/wiki";

    Either<Boolean, ScrapedEntity> scrape(String urlPath);
}

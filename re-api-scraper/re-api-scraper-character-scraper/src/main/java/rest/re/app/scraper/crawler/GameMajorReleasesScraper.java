package rest.re.app.scraper.crawler;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.crawler.utils.ScrapingUtils;

/**
 * Scrapes a RE wiki page that lists the games
 */
public class GameMajorReleasesScraper implements ReWikiScrapable {

    /**
     * Returns an HTML content of the /Resident_Evil_games#Major_releases page.
     * @return HTML Document
     */
    @Override
    public Single<Document> scrape() {
        return Single.just(Jsoup.connect(ScrapingUtils.appendUriPath(RESIDENT_WIKI_URL, "Resident_Evil_games#Major_releases")))
                .map(Connection::get)
                .retry();
    }
}

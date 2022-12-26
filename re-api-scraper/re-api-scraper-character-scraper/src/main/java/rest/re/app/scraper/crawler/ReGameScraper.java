package rest.re.app.scraper.crawler;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.crawler.utils.ScrapingUtils;

public class ReGameScraper implements ReWikiScrapable{
    private final String gamePath;

    public ReGameScraper(String gamePath) {
        this.gamePath = gamePath;
    }

    /**
     * Scrapes a Resident Evil Wiki Game Page.
     * @return HTML Document
     */
    @Override
    public Single<Document> scrape() {
        return Single.just(Jsoup.connect(ScrapingUtils.appendUriPath(RESIDENT_WIKI_URL, gamePath)))
                .map(Connection::get)
                .retry();
    }
}

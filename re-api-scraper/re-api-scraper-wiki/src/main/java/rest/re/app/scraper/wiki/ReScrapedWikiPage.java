package rest.re.app.scraper.wiki;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import rest.re.app.scraper.wiki.utils.ScrapingUtils;

import java.util.Optional;

/**
 * Scrapes a RE wiki page by a given urlPath
 */
public class ReScrapedWikiPage implements ReWikiScrapable {

    private final String urlPath;

    private ReScrapedWikiPage(String urlPath) {
        this.urlPath = urlPath;
    }

    public static ReWikiScrapable of(final String urlPath){
        return Optional.ofNullable(urlPath)
                .map(ReScrapedWikiPage::new)
                .orElse(new ReScrapedWikiPage(""));
    }


    /**
     * Returns an HTML content of the /Resident_Evil_games#Major_releases page.
     * @return HTML Document
     */
    @Override
    public Single<Document> scrape() {
        return Single.just(Jsoup.connect(ScrapingUtils.appendUriPath(RESIDENT_WIKI_URL, urlPath)))
                .map(Connection::get)
                .retry(5);
    }
}

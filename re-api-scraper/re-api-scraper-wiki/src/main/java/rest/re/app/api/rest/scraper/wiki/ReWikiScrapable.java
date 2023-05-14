package rest.re.app.api.rest.scraper.wiki;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.nodes.Document;

public interface ReWikiScrapable {
    String RESIDENT_WIKI_URL = "https://residentevil.fandom.com";

    Single<Document> scrape();
}

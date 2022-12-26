package rest.re.app.scraper.crawler;

import io.reactivex.rxjava3.core.Single;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class GameMajorReleasesScraper implements ReWikiScrapable {
    @Override
    public Single<Document> scrape() {
        return Single.just(Jsoup.connect(RESIDENT_WIKI_URL+"/Resident_Evil_games#Major_releases"))
                .map(Connection::get)
                .retry();
    }
}

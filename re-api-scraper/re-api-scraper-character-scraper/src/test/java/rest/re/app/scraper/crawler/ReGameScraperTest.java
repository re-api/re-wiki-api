package rest.re.app.scraper.crawler;

import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;



class ReGameScraperTest {

    @Test
    void returningHTMLListingCharsInRE2Game(){
        Single<List<String>> listSingle = new ReGameScraper("Resident_Evil_2_(1998)")
                .scrape()
                .map(document -> document.getElementsByClass("article-table"))
                .map(articleTable->articleTable.select("a"))
                .map(href->href.stream().map(l->l.attr("href")).collect(Collectors.toList()));

        List<String > hrefs = listSingle.test().values().get(0);

        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Leon_Scott_Kennedy")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Claire_Redfield")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Ada_Wong")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Sherry_Birkin")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/William_Birkin")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Annette_Birkin")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Brian_Irons")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Robert_Kendo")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Gary_Krawford")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Marvin_Branagh")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Ben_Bertolucci")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/HUNK")));

    }

}
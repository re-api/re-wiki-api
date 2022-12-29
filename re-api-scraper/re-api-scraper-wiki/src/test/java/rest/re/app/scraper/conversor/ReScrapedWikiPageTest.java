package rest.re.app.scraper.conversor;


import io.reactivex.rxjava3.core.Single;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import rest.re.app.scraper.wiki.ReScrapedWikiPage;
import rest.re.app.scraper.wiki.ReWikiScrapable;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class ReScrapedWikiPageTest {

    @Test
    void gameListPageScraperShouldScrapeAPageWithTitleResidentEvilGames(){
        rest.re.app.scraper.wiki.ReWikiScrapable gameListPage = ReScrapedWikiPage.of("wiki/Resident_Evil_games#Major_releases");
        Single<String> titleString = gameListPage.scrape()
                .map(doc-> Objects.requireNonNull(doc.getElementsByClass("page-header__title").first().text()));

        titleString.test().assertValue("Resident Evil games");
    }

    @Test
    void gameListPageScraperShouldReturnAnHTMLContainingLinksToAllGames(){
        rest.re.app.scraper.wiki.ReWikiScrapable gameListPage = ReScrapedWikiPage.of("wiki/Resident_Evil_games#Major_releases");
        Single<List<String>> listSingle =  gameListPage.scrape()
                .map(doc-> doc.getElementsByClass("image link-internal"))
                .map(elements -> elements.stream().map(element->element.attr("href")).collect(
                        Collectors.toList())
                );

        List<String> hrefs = listSingle.test().values().get(0);

        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_(1996)")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_2_(1998)")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_3:_Nemesis")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_CODE:Veronica")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_0")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_4")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_5")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil:_Revelations")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_6")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil:_Revelations_2")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_7:_Biohazard")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_2")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_3")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_Village")));
        Assertions.assertTrue(hrefs.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_4_(2023_game)")));


    }

    @Test
    void returningHTMLListingCharsInRE2Game(){
        Single<List<String>> listSingle = ReScrapedWikiPage.of("wiki/Resident_Evil_2_(1998)")
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

    @Test
    void returningHTMLContentOfLeonsPage(){
        ReWikiScrapable leonsPage = ReScrapedWikiPage.of("/wiki/Leon_Scott_Kennedy");

        Single<List<List<String>>> leonsAttributeSingle = leonsPage.scrape()
                .flatMap(doc -> Single
                        .zip(
                                Single.just(doc.getElementsByClass("pi-data-label")),
                                Single.just(doc.getElementsByClass("pi-data-value")),
                                (labels, values) -> IntStream.range(0, labels.size())
                                        .mapToObj(index -> Arrays.asList(labels.get(index).text(), values.get(index).text()))
                                        .collect(Collectors.toList())
                        ));

        List<List<String>> leonsAttribute = leonsAttributeSingle.test().values().get(0);

        Assertions.assertEquals("Police Officer (1998) US-STRATCOM Agent (1998–2011)[3] DSO Agent (2011–)",leonsAttribute.get(3).get(1));


    }

}
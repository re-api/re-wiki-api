package rest.re.app.scraper.crawler;


import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


class GameMajorReleasesScraperTest {

    @Test
    void scraperShouldScrapeAPageWithTitleResidentEvilGames(){
        Single<String> titleString = new GameMajorReleasesScraper().scrape()
                .map(doc-> Objects.requireNonNull(doc.getElementsByClass("page-header__title").first().text()));

        titleString.test().assertValue("Resident Evil games");
    }

    @Test
    void scraperShouldReturnAnHTMLContainingLinksToAllGames(){
        Single<List<String>> listSingle =  new GameMajorReleasesScraper().scrape()
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

}
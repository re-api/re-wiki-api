package flow.steps.charactersfetchingstep.impl;

import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepInput;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepOutput;
import flow.steps.execurableflowstep.ExecutableFlowStep;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.re.app.scraper.converter.Document2GameCharacterConverter;
import rest.re.app.scraper.wiki.ReScrapedWikiPage;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;


public class ScraperCharactersFetchingStepImpl implements ExecutableFlowStep<ScraperCharactersFetchingStepInput,
        ScraperCharactersFetchingStepOutput> {

    private static final Logger logger = LoggerFactory.getLogger(ScraperCharactersFetchingStepImpl.class);

    /**
     * Takes a list of Games URL Path in the input and returns a list of scraped games characters scraped from the
     * RE Wiki page.
     * @param input The input containing the list of games URL
     * @return The output containing the list of scraped game characters.
     */
    @Override
    public Single<ScraperCharactersFetchingStepOutput> execute(ScraperCharactersFetchingStepInput input) {
        logger.info("Executing the ScraperCharactersFetchingStepImpl stage!");

        logger.debug("The following input was given: {}", input);

        return Single.just(input.getGamesUrlPath())
                // Firstly, pull the list of characters FOR EACH Game URL path
                .map(listOfGamesPath->listOfGamesPath
                        .stream()
                        .map(gameWikiUrlPath->ReScrapedWikiPage.of(gameWikiUrlPath)
                                        .scrape()
                                        .map(document -> document.getElementsByClass("article-table"))
                                        .map(elements -> elements.select("tr td:eq(0)"))// <- this selects only characters, not voice actors.
                                        .map(articleTable->articleTable.select("a"))
                                        .map(href->href.stream().map(l->l.attr("href")))
                                        .map(foo->foo.collect(Collectors.toList()))
                                            .blockingGet()
                            )
                )
                // Secondly, flatmap the list into one big list of character wiki url
                .map(listOfListOfCharactersWikiUrl->listOfListOfCharactersWikiUrl
                        .flatMap(Collection::stream)
                )
                //Thirdly, remove duplicates urls:
                .map(listOfCharactersWikiUrl->new HashSet<>(listOfCharactersWikiUrl.collect(Collectors.toList())))
                // Fourthly, get an HTML document of each character wiki url page from the set.
                .map(setOfCharactersWikiUrl->setOfCharactersWikiUrl.stream()
                        .map(characterWikiUrl->ReScrapedWikiPage.of(characterWikiUrl).scrape().blockingGet())
                )
                // Fifthly, for each document in the stream, convert it into a ScrapedGameCharacter object.
                .map(lisOfCharacterHTMLDocument->lisOfCharacterHTMLDocument
                        .map(characterHTMLDocument-> new Document2GameCharacterConverter()
                                .convert(characterHTMLDocument)
                        )
                )
                // Convert stream back to list
                .map(scrapedGameCharacterStream -> scrapedGameCharacterStream.collect(Collectors.toList()))
                // Finally fill out the flow step output
                .map(listOfScrapedGameCharacters-> {
                    logger.debug("List of ScrapedGameCharacters: {}", listOfScrapedGameCharacters);
                    return new ScraperCharactersFetchingStepOutput()
                            .setListOfScrapedGameCharacters(listOfScrapedGameCharacters);
                });
    }
}

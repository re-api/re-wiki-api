package flow.steps.charactersfetchingstep.impl;

import common.lib.models.serializable.GameCharacter;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepInput;
import flow.steps.charactersfetchingstep.api.ScraperCharactersFetchingStepOutput;
import common.lib.executableflowsteps.ExecutableFlowStep;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.Disposable;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.re.app.scraper.converter.Document2GameCharacterConverter;
import rest.re.app.scraper.wiki.ReScrapedWikiPage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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
                .map(this::pullListOfCharactersForEachGameUrl)
                //Secondly, remove duplicates from list, since the same character may be present in more than 1 game.
                .map(HashSet::new)
                // Thirdly, get an HTML document of each character wiki url page from the set.
                .map(this::retrieveAListOfHTMLDocumentForEachWikiUrlPath)
                // Fourthly, for each document in the stream, convert it into a ScrapedGameCharacter object.
                .map(this::convertEachDocumentFromListIntoScrapedGameCharacter)
                // Convert stream back to list
                .map(scrapedGameCharacterStream -> scrapedGameCharacterStream.collect(Collectors.toList()))
                // Finally fill out the flow step output
                .map(listOfScrapedGameCharacters-> {
                    logger.debug("List of ScrapedGameCharacters: {}", listOfScrapedGameCharacters);

                    return new ScraperCharactersFetchingStepOutput()
                            .setListOfScrapedGameCharacters(listOfScrapedGameCharacters);
                });
    }

    private List<String> pullListOfCharactersForEachGameUrl(List<String> listOfGamesUrlPath){
        List<String> charactersWikiUrlPath = new ArrayList<>();

        Disposable disposable = listOfGamesUrlPath.forEach(gameWikiUrlPath->ReScrapedWikiPage.of(gameWikiUrlPath)
                    .scrape()
                    .map(document -> document.getElementsByClass("article-table"))
                    .map(elements -> elements.select("tr td:eq(0)"))// <- this selects only characters, not voice actors.
                    .map(articleTable->articleTable.select("a"))
                    .map(href->href.stream().map(l->l.attr("href"))
                            .collect(Collectors.toList()))
                    .subscribe(charactersWikiUrlPath::addAll));

        disposable.dispose();

        return charactersWikiUrlPath;
    }

    private List<Document> retrieveAListOfHTMLDocumentForEachWikiUrlPath(Set<String> nonDuplicateCharacterWikiUrlPath){
        List<Document> documentList = new ArrayList<>();
        Disposable disposable = nonDuplicateCharacterWikiUrlPath.forEach(characterWikiUrl -> ReScrapedWikiPage
                .of(characterWikiUrl).scrape().subscribe(documentList::add));

        disposable.dispose();
        return documentList;
    }

    private Stream<GameCharacter> convertEachDocumentFromListIntoScrapedGameCharacter(
            List<Document> lisOfCharacterHTMLDocument){
        return lisOfCharacterHTMLDocument.stream()
                .map(characterHTMLDocument-> new Document2GameCharacterConverter().convert(characterHTMLDocument));
    }
}

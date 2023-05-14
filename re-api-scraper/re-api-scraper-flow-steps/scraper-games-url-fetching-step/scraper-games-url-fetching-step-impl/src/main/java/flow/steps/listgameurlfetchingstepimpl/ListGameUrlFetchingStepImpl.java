package flow.steps.listgameurlfetchingstepimpl;

import common.lib.executableflowsteps.ExecutableFlowStep;
import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepInput;
import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepOutput;
import io.reactivex.rxjava3.core.Single;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rest.re.app.api.rest.scraper.wiki.ReScrapedWikiPage;

import java.util.stream.Collectors;

public class ListGameUrlFetchingStepImpl implements ExecutableFlowStep<ListGameUrlFetchingStepInput,
        ListGameUrlFetchingStepOutput> {

    private static final Logger logger = LoggerFactory.getLogger(ListGameUrlFetchingStepImpl.class);


    /**
     * Takes an input containing a link URL path for a WIKI games page and returns an output step containing a
     * list of URLs that lead to each game.
     * @param input The input containing the RE WIKI URL game page.
     * @return The output containing a list of WIKI URL game pages.
     */
    @Override
    public Single<ListGameUrlFetchingStepOutput> execute(ListGameUrlFetchingStepInput input) {

        logger.info("Executing the ListGameUrlFetchingStepImpl stage.");

        return ReScrapedWikiPage
                .of(input.getResidentEvilGamesUrlPath())
                .scrape()
                .map(doc-> doc.getElementsByClass("image link-internal"))
                .map(elements -> elements.stream().map(element->element.attr("href")).collect(
                        Collectors.toList())
                ).map(listOfGamePaths-> {

                    logger.debug("List of URLs fetched: {}", listOfGamePaths);

                    return new ListGameUrlFetchingStepOutput()
                            .setListOfGamesUrl(listOfGamePaths);
                });
    }
}

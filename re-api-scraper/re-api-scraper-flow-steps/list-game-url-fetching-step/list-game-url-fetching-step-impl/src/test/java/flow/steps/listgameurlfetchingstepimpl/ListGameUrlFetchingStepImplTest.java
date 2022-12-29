package flow.steps.listgameurlfetchingstepimpl;

import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepInput;
import flow.steps.listgameurlfetchingstep.ListGameUrlFetchingStepOutput;
import io.reactivex.rxjava3.core.Single;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class ListGameUrlFetchingStepImplTest {

    @Test
    void testingTheFetchOfGamesUrl(){
        ListGameUrlFetchingStepImpl listGameUrlFetchingStepImpl = new ListGameUrlFetchingStepImpl();

        Single<ListGameUrlFetchingStepOutput> listGameUrlFetchingStepOutput = listGameUrlFetchingStepImpl
                .execute(new ListGameUrlFetchingStepInput()
                        .setResidentEvilGamesUrlPath("wiki/Resident_Evil_games#Major_releases"));

        List<String> gameUrls = listGameUrlFetchingStepOutput.test().values().get(0).getListOfGamesUrl();

        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_(1996)")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_2_(1998)")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_3:_Nemesis")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_CODE:Veronica")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_0")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_4")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_5")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil:_Revelations")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_6")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil:_Revelations_2")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_7:_Biohazard")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_2")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_3")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_Village")));
        Assertions.assertTrue(gameUrls.stream().anyMatch(href->href.equals("/wiki/Resident_Evil_4_(2023_game)")));


    }
}
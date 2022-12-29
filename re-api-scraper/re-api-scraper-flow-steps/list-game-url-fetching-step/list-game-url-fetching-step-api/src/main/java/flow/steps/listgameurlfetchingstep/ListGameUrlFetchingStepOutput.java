package flow.steps.listgameurlfetchingstep;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ListGameUrlFetchingStepOutput {

    private List<String> listOfGamesUrl;
}

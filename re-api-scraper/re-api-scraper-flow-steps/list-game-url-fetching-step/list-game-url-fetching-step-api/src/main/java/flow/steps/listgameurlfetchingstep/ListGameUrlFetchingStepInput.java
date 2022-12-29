package flow.steps.listgameurlfetchingstep;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ListGameUrlFetchingStepInput {

    private String residentEvilGamesUrlPath;
}

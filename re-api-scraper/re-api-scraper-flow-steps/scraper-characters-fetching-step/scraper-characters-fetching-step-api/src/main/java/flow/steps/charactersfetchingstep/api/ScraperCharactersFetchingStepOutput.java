package flow.steps.charactersfetchingstep.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import rest.re.app.api.rest.api.model.GameCharacter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ScraperCharactersFetchingStepOutput {

    List<GameCharacter> listOfScrapedGameCharacters;
}

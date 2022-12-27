package rest.re.app.scraper.converter.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
public class GameCharacter {

    @JsonProperty("dateOfBirth")
    private String dateOfBirth;

    @JsonProperty("dateOfDeath")
    private String dateOfDeath;

    @JsonProperty("placeOfBirth")
    private String placeOfBirth;

    @JsonProperty("placeOfDeath")
    private String placeOfDeath;

    @JsonProperty("race")
    private String race;

    @JsonProperty("occupation")
    private String occupation;

    @JsonProperty("status")
    private String status;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("bloodType")
    private String bloodType;

    @JsonProperty("height")
    private String height;

    @JsonProperty("bodyMass")
    private String bodyMass;

    @JsonProperty("firstAppearance")
    private String firstAppearance;

    @JsonProperty("lastAppearance")
    private String lastAppearance;

}

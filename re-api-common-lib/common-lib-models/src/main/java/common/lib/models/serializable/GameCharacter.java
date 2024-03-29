package common.lib.models.serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * Scraped Game Character Schema
 * This is a serializable class that will represent the Scraped HTML content of a character.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
public class GameCharacter {

    @JsonProperty("name")
    private String name;

    @JsonProperty("localization")
    private String localization;

    @JsonProperty("description")
    private String description;

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
    private List<String> occupation;

    @JsonProperty("status")
    private String status;

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("bloodType")
    private String bloodType;

    @JsonProperty("height")
    private Height height;

    @JsonProperty("bodyMass")
    private BodyMass bodyMass;

    @JsonProperty("firstAppearance")
    private String firstAppearance;

    @JsonProperty("lastAppearance")
    private String lastAppearance;

}

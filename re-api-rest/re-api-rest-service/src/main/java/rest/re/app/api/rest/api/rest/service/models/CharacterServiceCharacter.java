package rest.re.app.api.rest.api.rest.service.models;

import lombok.Data;
import lombok.experimental.Accessors;


import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.UUID;

@Entity(name = "characters")
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@Data
@Accessors(chain = true)
public class CharacterServiceCharacter {


    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "localization")
    private String localization;

    @Column(name = "description")
    private String description;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "dateOfDeath")
    private String dateOfDeath;

    @Column(name = "placeOfBirth")
    private String placeOfBirth;

    @Column(name = "placeOfDeath")
    private String placeOfDeath;

    @Column(name = "race")
    private String race;

    @ElementCollection
    @CollectionTable(name = "occupation", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "occupation")
    private List<String> occupation;

    @Column(name = "status")
    private String status;

    @Column(name = "sex")
    private String sex;

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "height")
    private Integer height;

    @Column(name = "bodyMass")
    private Double bodyMass;

    @Column(name = "firstAppearance")
    private String firstAppearance;

    @Column(name = "lastAppearance")
    private String lastAppearance;

}

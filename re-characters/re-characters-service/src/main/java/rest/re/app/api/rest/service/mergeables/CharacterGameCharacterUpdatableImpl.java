package rest.re.app.api.rest.service.mergeables;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import rest.re.app.api.rest.service.models.CharacterServiceCharacter;

@AllArgsConstructor(staticName = "of")
public class CharacterGameCharacterUpdatableImpl implements CharacterGameCharacterUpdatable<CharacterServiceCharacter> {

    private CharacterServiceCharacter currentCharacterGameCharacter;
    private CharacterServiceCharacter updatedCharacterGameCharacter;

    /**
     * Rule to update the name:
     * - The name must never be reduced, for example: Leon Scott Kennedy to Leon S. Kennedy.
     * - The name can be increased, for example: Ada W. to Ada Wong.
     * - If the update is to turn name into null, then do not update.
     * - If the update is to turn the name into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateName() {
        return null;
    }

    /**
     * Rule to update the localization:
     * - If the update is to turn localization into null, then do not update.
     * - If the update is to turn the localization into an empty string, then do not update.
     * - else update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateLocalization() {
        return null;
    }

    /**
     * Rule to update the Description:
     * - If the update is to turn Description into null, then do not update.
     * - If the update is to turn the Description into an empty string, then do not update.
     * - else update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateDescription() {
        return null;
    }

    /**
     * Rule to update the DateOfBirth:
     * - If the current dateOfBirth only has the year, but the update contains the month and day, then update.
     * - If the update comes with a different year, then do not update.
     * - If the update only a year, but the current contains day, month and year, do not update.
     * - If the update is to turn DateOfBirth into null, then do not update.
     * - If the update is to turn the DateOfBirth into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateDateOfBirth() {
        return null;
    }

    /**
     * Rule to update the DateOfDeath:
     * - If the current DateOfDeath only has the year, but the update contains the month and day, then update.
     * - If the update comes with a different year, then do not update.
     * - If the update only a year, but the current contains day, month and year, do not update.
     * - If the update is to turn DateOfDeath into null, then do not update.
     * - If the update is to turn the DateOfDeath into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateDateOfDeath() {
        return null;
    }

    /**
     * Rule to update the PlaceOfBirth:
     * - If the update is to turn PlaceOfBirth into null, then do not update.
     * - If the update is to turn the PlaceOfBirth into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updatePlaceOfBirth() {
        return null;
    }

    /**
     * Rule to update the PlaceOfDeath:
     * - If the update is to turn PlaceOfDeath into null, then do not update.
     * - If the update is to turn the PlaceOfDeath into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updatePlaceOfDeath() {
        return null;
    }

    /**
     * Rule to update the Race:
     * - If the update is to turn Race into null, then do not update.
     * - If the update is to turn the Race into an empty string, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateRace() {
        return null;
    }

    /**
     * Rule to update the Occupations:
     * - If the update is to turn Occupations into null, then do not update.
     * - If the update list is bigger than the current, update the new occupation.
     * - If the update comes with fewer occupations, update the current as long as the occupations aren't already in the current.
     * - If the same occupation comes, but with different finish years, update the occupation as long as the finish year of the update is greater than the finish year of the current.
     * - If the same occupation comes but with different start year, update regardless.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateOccupations() {
        return null;
    }


    /**
     * Rule to update the Status:
     * - If changed from Deceased to Alive, if place of death is not null, do not update.
     * - If changed from Unknown to any other, always update.
     * - If changed from Alive to Deceased, always update.
     * - If the update is to turn Status into null, then do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateStatus() {
        return null;
    }

    /**
     * Rule to update the Sex:
     * - If the update is to turn Sex into null, then do not update.
     * - If the update is to turn null into a sex, then update.
     * - If sex is already in the current, do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateSex() {
        return null;
    }

    /**
     * Rule to update the BloodType:
     * - If the update is to turn BloodType into null, then do not update.
     * - If the update is to turn null into a BloodType, then update.
     * - If BloodType is already in the current, do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateBloodType() {
        return null;
    }

    /**
     * Rule to update the Height:
     * - If the update is to turn Height into null, then do not update.
     * - If the update is to turn null into a Height, then update.
     * - If BloodType is already in the current, do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateHeight() {
        return null;
    }

    /**
     * Rule to update the BodyMass:
     * - If the update is to turn BodyMass into null, then do not update.
     * - If the update is to turn null into a BodyMass, then update.
     * - If BodyMass is already in the current, do not update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateBodyMass() {
        return null;
    }

    /**
     * Rule to update the FirstAppearance:
     * - If the update is to turn FirstAppearance into null, then do not update.
     * - If the update is to turn null into a FirstAppearance, then update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateFirstAppearance() {
        return null;
    }

    /**
     * Rule to update the LastAppearance:
     * - If the update is to turn LastAppearance into null, then do not update.
     * - If the update is to turn null into a LastAppearance, then update.
     *
     * @return an instance of the CharacterGameCharacterupdateable
     */
    @Override
    public CharacterGameCharacterUpdatable<CharacterServiceCharacter> updateLastAppearance() {
        return null;
    }
}

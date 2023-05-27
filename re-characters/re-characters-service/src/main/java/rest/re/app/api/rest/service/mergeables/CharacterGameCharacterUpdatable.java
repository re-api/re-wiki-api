package rest.re.app.api.rest.service.mergeables;

import rest.re.app.api.rest.service.models.CharacterServiceCharacter;

public interface CharacterGameCharacterUpdatable<T extends CharacterServiceCharacter> {

    CharacterGameCharacterUpdatable<T> updateName();
    CharacterGameCharacterUpdatable<T> updateLocalization();
    CharacterGameCharacterUpdatable<T> updateDescription();
    CharacterGameCharacterUpdatable<T> updateDateOfBirth();
    CharacterGameCharacterUpdatable<T> updateDateOfDeath();
    CharacterGameCharacterUpdatable<T> updatePlaceOfBirth();
    CharacterGameCharacterUpdatable<T> updatePlaceOfDeath();
    CharacterGameCharacterUpdatable<T> updateRace();
    CharacterGameCharacterUpdatable<T> updateOccupations();
    CharacterGameCharacterUpdatable<T> updateStatus();
    CharacterGameCharacterUpdatable<T> updateSex();
    CharacterGameCharacterUpdatable<T> updateBloodType();
    CharacterGameCharacterUpdatable<T> updateHeight();
    CharacterGameCharacterUpdatable<T> updateBodyMass();
    CharacterGameCharacterUpdatable<T> updateFirstAppearance();
    CharacterGameCharacterUpdatable<T> updateLastAppearance();
}

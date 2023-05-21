package rest.re.app.api.rest.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rest.re.app.api.rest.service.models.CharacterServiceCharacter;

import java.util.List;
import java.util.UUID;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterServiceCharacter, UUID> {

    List<CharacterServiceCharacter> findByName(final String name);

}

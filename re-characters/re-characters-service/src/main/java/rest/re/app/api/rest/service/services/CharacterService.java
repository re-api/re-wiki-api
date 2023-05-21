package rest.re.app.api.rest.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import re.api.common.lib.CRUDService;
import rest.re.app.api.rest.service.models.CharacterServiceCharacter;
import rest.re.app.api.rest.service.repositories.CharacterRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class CharacterService implements CRUDService<CharacterServiceCharacter> {

    @Autowired
    private CharacterRepository characterRepository;


    @Override
    public List<CharacterServiceCharacter> findByName(String name) {
        return characterRepository.findByName(name);
    }

    @Override
    public List<CharacterServiceCharacter> listAll() {
        return characterRepository.findAll();
    }

    @Override
    public CharacterServiceCharacter getById(UUID uuid) {
        return characterRepository.getReferenceById(uuid);
    }

    @Override
    public boolean save(CharacterServiceCharacter characterServiceCharacter) {
        final CharacterServiceCharacter savedCharacter = characterRepository.save(characterServiceCharacter);
        return Objects.nonNull(savedCharacter);
    }

    @Override
    public boolean deleteById(UUID uuid) {
        try{
            characterRepository.deleteById(uuid);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}

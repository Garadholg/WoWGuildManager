package com.amaurov.wowguildmanager.services.interfaces;

import com.amaurov.wowguildmanager.models.Character;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CharacterService {
    Set<Class> getAllClasses();
    Set<Specialization> getAllSpecs();
    Optional<List<Character>> getCharactersForUser(String username);
    void createCharacter(String username, String characterName, int specID);

    Optional<CharacterEntity> getCharacterFullInfo(int characterId);
}

package com.amaurov.wowguildmanager.services.interfaces;

import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CharacterService {
    Set<Class> getAllClasses();
    Set<Specialization> getAllSpecs();
    void createCharacter(String username, String characterName, int specID);

    Optional<CharacterEntity> getCharacterFullInfo(int characterId);
    Optional<List<CharacterEntity>> getCharactersInfoForUser(String username);
    boolean characterExists(int characterId);
    boolean isCharacterOfLoggedUser(int characterId);
}

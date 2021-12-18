package com.amaurov.wowguildmanager.services.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.jdbc.CharacterRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jdbc.ClassRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jdbc.SpecRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jpa.CharacterJpaRepository;
import com.amaurov.wowguildmanager.models.Character;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import com.amaurov.wowguildmanager.services.interfaces.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final ClassRepository classRepository;
    private final SpecRepository specRepository;
    private final CharacterRepository characterRepository;
    private final CharacterJpaRepository characterJpaRepository;

    public Set<Class> getAllClasses() {
        return classRepository.getAll();
    }

    @Override
    public Set<Specialization> getAllSpecs() {
        return specRepository.getAll();
    }

    @Override
    public void createCharacter(String username, String characterName, int specID) {
        characterRepository.create(
                new Character(
                        0,
                        username,
                        characterName,
                        specRepository.getByID(specID),
                        false
                )
        );
    }

    @Override
    public Optional<CharacterEntity> getCharacterFullInfo(int characterId) {
        return characterJpaRepository.findById(characterId);
    }

    @Override
    public Optional<List<CharacterEntity>> getCharactersInfoForUser(String username) {
        return characterJpaRepository.findAllByUser(username);
    }

    @Override
    public boolean characterExists(int characterId) {
        return characterJpaRepository.existsById(characterId);
    }

    @Override
    public boolean isCharacterOfLoggedUser(int characterId) {
        CharacterEntity character = characterJpaRepository.findById(characterId).get();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return character.getUser().equals(auth.getName())
                || auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"));
    }

}

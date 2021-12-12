package com.amaurov.wowguildmanager.services.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.CharacterRepository;
import com.amaurov.wowguildmanager.dal.interfaces.ClassRepository;
import com.amaurov.wowguildmanager.dal.interfaces.SpecRepository;
import com.amaurov.wowguildmanager.models.Character;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import com.amaurov.wowguildmanager.services.interfaces.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final ClassRepository classRepository;
    private final SpecRepository specRepository;
    private final CharacterRepository charRepository;

    public Set<Class> getAllClasses() {
        return classRepository.getAll();
    }

    @Override
    public Set<Specialization> getAllSpecs() {
        return specRepository.getAll();
    }

    @Override
    public Optional<List<Character>> getCharactersForUser(String username) {
        return charRepository.getAllForUser(username);
    }

    @Override
    public void createCharacter(String username, String characterName, int specID) {
        charRepository.create(
                new Character(
                        0,
                        username,
                        characterName,
                        specRepository.getByID(specID),
                        false
                )
        );
    }

}

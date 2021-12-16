package com.amaurov.wowguildmanager.dal.interfaces.jdbc;

import com.amaurov.wowguildmanager.models.Character;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository {
    Optional<List<Character>> getAllForUser(String username);
    int create(Character character);
}

package com.amaurov.wowguildmanager.dal.interfaces.jpa;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterJpaRepository extends CrudRepository<CharacterEntity, Integer> {

    Optional<CharacterEntity> findById(int id);

    Optional<List<CharacterEntity>> findAllByUser(String username);
}

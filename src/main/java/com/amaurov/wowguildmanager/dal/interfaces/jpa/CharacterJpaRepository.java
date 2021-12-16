package com.amaurov.wowguildmanager.dal.interfaces.jpa;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CharacterJpaRepository extends CrudRepository<CharacterEntity, Long> {

    Optional<CharacterEntity> findById(int id);

}

package com.amaurov.wowguildmanager.dal.interfaces.jpa;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterItemEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.ItemEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.ItemSlotEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CharacterItemJpaRepository extends CrudRepository<CharacterItemEntity, Integer> {
    Optional<CharacterItemEntity> findByCharacterAndSlot(CharacterEntity character, ItemSlotEntity slot);
    Optional<CharacterItemEntity> findByCharacterAndItem(CharacterEntity character, ItemEntity item);
}

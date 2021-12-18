package com.amaurov.wowguildmanager.dal.interfaces.jpa;

import com.amaurov.wowguildmanager.models.jpaEntities.ItemSlotEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemSlotJpaRepository extends CrudRepository<ItemSlotEntity, Integer> {
}

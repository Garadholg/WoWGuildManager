package com.amaurov.wowguildmanager.dal.interfaces.jpa;

import com.amaurov.wowguildmanager.models.jpaEntities.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemJpaRepository extends CrudRepository<ItemEntity, Integer> {
}

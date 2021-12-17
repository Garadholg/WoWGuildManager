package com.amaurov.wowguildmanager.services.interfaces;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterItemEntity;

public interface EquipmentService {
    CharacterItemEntity equipItem(int characterId, int itemId);
    void unequipItem (int characterId, int itemId);
    boolean itemExists(int itemId);
}

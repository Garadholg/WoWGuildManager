package com.amaurov.wowguildmanager.services.interfaces;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterItemEntity;

import java.security.Principal;

public interface EquipmentService {
    CharacterItemEntity equipItem(int characterId, int itemId);
    void unequipItem (int characterId, int itemId);
    boolean itemExists(int itemId);
    boolean slotExistsForCharacter(int characterId, int slotId);
}

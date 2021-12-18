package com.amaurov.wowguildmanager.services.implementations;

import com.amaurov.wowguildmanager.dal.interfaces.jpa.CharacterItemJpaRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jpa.CharacterJpaRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jpa.ItemJpaRepository;
import com.amaurov.wowguildmanager.dal.interfaces.jpa.ItemSlotJpaRepository;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.CharacterItemEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.ItemEntity;
import com.amaurov.wowguildmanager.models.jpaEntities.ItemSlotEntity;
import com.amaurov.wowguildmanager.services.interfaces.EquipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final CharacterItemJpaRepository characterItemJpaRepository;
    private final CharacterJpaRepository characterJpaRepository;
    private final ItemJpaRepository itemJpaRepository;
    private final ItemSlotJpaRepository itemSlotJpaRepository;

    @Override
    public CharacterItemEntity equipItem(int characterId, int itemId) {
        CharacterEntity character = characterJpaRepository.findById(characterId).get();
        ItemEntity item = itemJpaRepository.findById(itemId).get();

        Optional<CharacterItemEntity> characterItem = characterItemJpaRepository.findByCharacterAndSlot(character, item.getSlot());
        if (characterItem.isPresent()) {
            CharacterItemEntity existingCharacterItem = characterItem.get();
            existingCharacterItem.setItem(item);
            return characterItemJpaRepository.save(existingCharacterItem);
        } else {
            CharacterItemEntity newCharacterItem = new CharacterItemEntity(character, item.getSlot(), item);
            return characterItemJpaRepository.save(newCharacterItem);
        }
    }

    @Override
    public void unequipItem(int characterId, int slotId) {
        CharacterEntity character = characterJpaRepository.findById(characterId).get();
        ItemSlotEntity slot = itemSlotJpaRepository.findById(slotId).get();

        Optional<CharacterItemEntity> characterItem = characterItemJpaRepository.findByCharacterAndSlot(character, slot);

        if (characterItem.isPresent()) {
            characterItemJpaRepository.deleteById(characterItem.get().getId());
        }
    }

    @Override
    public boolean itemExists(int itemId) {
        return itemJpaRepository.existsById(itemId);
    }

    @Override
    public boolean slotExistsForCharacter(int characterId, int slotId) {
        CharacterEntity character = characterJpaRepository.findById(characterId).get();
        ItemSlotEntity slot = itemSlotJpaRepository.findById(slotId).get();

        return characterItemJpaRepository.existsByCharacterAndSlot(character, slot);
    }
}

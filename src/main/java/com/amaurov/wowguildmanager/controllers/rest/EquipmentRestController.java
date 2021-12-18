package com.amaurov.wowguildmanager.controllers.rest;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterItemEntity;
import com.amaurov.wowguildmanager.services.interfaces.CharacterService;
import com.amaurov.wowguildmanager.services.interfaces.EquipmentService;
import com.amaurov.wowguildmanager.utils.messaging.requests.EquipItemRequest;
import com.amaurov.wowguildmanager.utils.messaging.requests.UnequipItemRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping(path = "api/equipment")
@RequiredArgsConstructor
public class EquipmentRestController {

    private final CharacterService characterService;
    private final EquipmentService equipmentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("equip")
    public CharacterItemEntity equipItem(@Valid @RequestBody EquipItemRequest request) {
        if (!characterService.characterExists(request.getCharacterId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The character with the id " + request.getCharacterId() + " does not exist");
        }

        if (!equipmentService.itemExists(request.getItemId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The item with the id " + request.getItemId() + " does not exist");
        }

        if (!characterService.isCharacterOfLoggedUser(request.getCharacterId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character management is allowed only for the characters of the logged user");
        }

        return equipmentService.equipItem(request.getCharacterId(), request.getItemId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("unequip")
    public void unequipItem(@Valid @RequestBody UnequipItemRequest request) {
        if (!characterService.isCharacterOfLoggedUser(request.getCharacterId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Character management is allowed only for the characters of the logged user");
        }

        if (!characterService.characterExists(request.getCharacterId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The character with the id " + request.getCharacterId() + " does not exist");
        }

        if (!equipmentService.slotExistsForCharacter(request.getCharacterId(), request.getSlotId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The character does not have an item equipped in the slot " + request.getSlotId());
        }

        equipmentService.unequipItem(request.getCharacterId(), request.getSlotId());
    }
}

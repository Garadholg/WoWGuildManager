package com.amaurov.wowguildmanager.controllers.rest;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.services.implementations.CharacterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api/character")
@RequiredArgsConstructor
public class CharacterRestController {

    private final CharacterServiceImpl characterService;

    @GetMapping("{characterId}")
    public CharacterEntity getCharacterFullInfo(@PathVariable int characterId) {
        return characterService.getCharacterFullInfo(characterId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The character was not found!")
                );
    }

}

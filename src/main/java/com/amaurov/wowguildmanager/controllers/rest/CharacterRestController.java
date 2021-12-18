package com.amaurov.wowguildmanager.controllers.rest;

import com.amaurov.wowguildmanager.models.jpaEntities.CharacterEntity;
import com.amaurov.wowguildmanager.services.implementations.CharacterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "api/characters")
@RequiredArgsConstructor
public class CharacterRestController {

    private final CharacterServiceImpl characterService;

    //@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("{characterId}")
    public CharacterEntity getCharacterFullInfo(@PathVariable int characterId) {
        return characterService.getCharacterFullInfo(characterId)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The character was not found!")
                );
    }

    @GetMapping
    public List<CharacterEntity> getCharactersInfoForUser(Principal principal) {
        return characterService.getCharactersInfoForUser(principal.getName())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "The user does not have any character!")
                );
    }

}

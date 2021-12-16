package com.amaurov.wowguildmanager.controllers;

import com.amaurov.wowguildmanager.models.Character;
import com.amaurov.wowguildmanager.models.Class;
import com.amaurov.wowguildmanager.models.Specialization;
import com.amaurov.wowguildmanager.services.interfaces.CharacterService;
import com.amaurov.wowguildmanager.utils.formData.CharacterCreationFormData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping("/user/characters")
public class CharacterController {

    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping()
    public String characterCustomizationScreen(Model model) {
        Set<Class> classes = characterService.getAllClasses();
        model.addAttribute("classes", classes);

        Set<Specialization> specs = characterService.getAllSpecs();
        model.addAttribute("specs", specs);

        Optional<List<Character>> characters = characterService.getCharactersForUser("amaurov");
        model.addAttribute("chars", characters.get());

        model.addAttribute("createFormData", new CharacterCreationFormData());

        return "character-customization";
    }

    @PostMapping("new")
    public String createCharacterForUser(@Valid CharacterCreationFormData formData, Errors errors, Principal principal, Model model) {
        if (!errors.hasErrors()) {
            characterService.createCharacter(principal.getName(), formData.getCharacterName(), formData.getSpecID());
        }

        return "redirect:/user/characters";
    }
}

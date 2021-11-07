package com.amaurov.wowguildmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/characters")
public class CharacterController {

    @GetMapping()
    public String characterCustomizationScreen() {
        return "character-customization";
    }
}

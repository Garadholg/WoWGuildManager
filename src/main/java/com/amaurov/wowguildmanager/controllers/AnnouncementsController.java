package com.amaurov.wowguildmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("board")
public class AnnouncementsController {

    @GetMapping()
    public String showAnnouncements() {
        return "announcements";
    }
}

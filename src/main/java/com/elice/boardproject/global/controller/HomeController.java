package com.elice.boardproject.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    public HomeController() {
    }

    @GetMapping
    public String home() {
        return "redirect:/boards";
    }
}
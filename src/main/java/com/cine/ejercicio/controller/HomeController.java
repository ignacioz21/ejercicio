package com.cine.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.cine.ejercicio.service.MovieService;

@Controller
public class HomeController {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
}

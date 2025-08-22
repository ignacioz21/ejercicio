package com.cine.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cine.ejercicio.domain.Show;
import com.cine.ejercicio.service.MovieService;
import com.cine.ejercicio.service.ShowService;

@Controller
public class ShowController {
    
    @Autowired
    private ShowService showService;
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping("/shows")
    public String listShows(Model model) {
        model.addAttribute("shows", showService.findAll());
        return "shows";
    }
    
    @GetMapping("/admin/shows")
    public String adminShows(Model model) {
        model.addAttribute("shows", showService.findAll());
        //model.addAttribute("movie", new Movie());
        return "admin/shows";
    }
    
    @GetMapping("/admin/shows/new")
    public String newShow(Model model) {
        model.addAttribute("show", new Show());
        model.addAttribute("movies", movieService.findAll());
        return "admin/show-form";
    }
    
    @PostMapping("/admin/shows")
    public String saveShow(@ModelAttribute Show show) {
        showService.save(show);
        return "redirect:/admin/shows";
    }
}

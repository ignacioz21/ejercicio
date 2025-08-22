package com.cine.ejercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cine.ejercicio.domain.Movie;
import com.cine.ejercicio.service.MovieService;

@Controller
@RequestMapping("/admin/movies")
public class MovieController {
    
    @Autowired
    private MovieService movieService;
    
    @GetMapping
    public String listMovies(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "admin/movies";
    }
    
    @GetMapping("/new")
    public String newMovie(Model model) {
        model.addAttribute("movie", new Movie());
        return "admin/movie-form";
    }
    
    @GetMapping("/{id}/edit")
    public String editMovie(@PathVariable Long id, Model model) {
        movieService.findById(id).ifPresent(movie -> model.addAttribute("movie", movie));
        return "admin/movie-form";
    }
    
    @PostMapping
    public String saveMovie(@ModelAttribute Movie movie) {
        movieService.save(movie);
        return "redirect:/admin/movies";
    }
    
    @GetMapping("/{id}/delete")
    public String deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return "redirect:/admin/movies";
    }
}

package com.cine.ejercicio.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private String genre;
    private Integer duration;
    private String director;
    private String trailerUrl;
    
    public Movie() {}
    
    public Movie(String title, String description, String genre, Integer duration, String director, String trailerUrl) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.director = director;
        this.trailerUrl = trailerUrl;
    }
    
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
    
    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }
    
    public Integer getDuration() { return duration; }

    public void setDuration(Integer duration) { this.duration = duration; }
    
    public String getDirector() { return director; }

    public void setDirector(String director) { this.director = director; }
    
    public String getTrailerUrl() { return trailerUrl; }
    
    public void setTrailerUrl(String trailerUrl) { this.trailerUrl = trailerUrl; }
}

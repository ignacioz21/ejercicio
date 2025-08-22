package com.cine.ejercicio.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "shows")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    
    private LocalDateTime showTime;
    private Double price;
    private Integer availableSeats;
    private String room;
    
    // Constructors
    public Show() {}
    
    public Show(Movie movie, LocalDateTime showTime, Double price, Integer availableSeats, String room) {
        this.movie = movie;
        this.showTime = showTime;
        this.price = price;
        this.availableSeats = availableSeats;
        this.room = room;
    }
    
    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    
    public Movie getMovie() { return movie; }

    public void setMovie(Movie movie) { this.movie = movie; }
    
    public LocalDateTime getShowTime() { return showTime; }

    public void setShowTime(LocalDateTime showTime) { this.showTime = showTime; }
    
    public Double getPrice() { return price; }

    public void setPrice(Double price) { this.price = price; }
    
    public Integer getAvailableSeats() { return availableSeats; }

    public void setAvailableSeats(Integer availableSeats) { this.availableSeats = availableSeats; }
    
    public String getRoom() { return room; }
    
    public void setRoom(String room) { this.room = room; }
}

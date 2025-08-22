package com.cine.ejercicio.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    
    private Integer seats;
    private LocalDateTime reservationDate;
    private Double totalPrice;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    

    public Reservation() {
        
    }
    
    public Reservation(User user, Show show, Integer seats, LocalDateTime reservationDate, Double totalPrice, Status status) {
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.reservationDate = reservationDate;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }
    
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
    
    public Show getShow() { return show; }

    public void setShow(Show show) { this.show = show; }
    
    public Integer getSeats() { return seats; }

    public void setSeats(Integer seats) { this.seats = seats; }
    
    public LocalDateTime getReservationDate() { return reservationDate; }

    public void setReservationDate(LocalDateTime reservationDate) { this.reservationDate = reservationDate; }
    
    public Double getTotalPrice() { return totalPrice; }

    public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }
    
    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }
    
    public enum Status {
        ACTIVE, CANCELLED
    }
}
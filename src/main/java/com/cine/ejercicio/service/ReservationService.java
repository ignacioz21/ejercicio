package com.cine.ejercicio.service;

import java.util.List;
import java.util.Optional;

import com.cine.ejercicio.domain.Reservation;
import com.cine.ejercicio.domain.User;

public interface ReservationService {
    List<Reservation> findAll();
    List<Reservation> findByUser(User user);
    Optional<Reservation> findById(Long id);
    Reservation save(Reservation reservation);
    void cancelReservation(Long id);
}

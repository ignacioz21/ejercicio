package com.cine.ejercicio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.ejercicio.domain.Reservation;
import com.cine.ejercicio.domain.User;

@Repository
public interface ReservatioDao extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
}

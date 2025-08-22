package com.cine.ejercicio.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.ejercicio.domain.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Long> {
}

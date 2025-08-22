package com.cine.ejercicio.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cine.ejercicio.domain.Show;

@Repository
public interface ShowDao extends JpaRepository<Show, Long> {
}

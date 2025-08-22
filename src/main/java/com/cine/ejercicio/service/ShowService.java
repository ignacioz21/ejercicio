package com.cine.ejercicio.service;

import java.util.List;
import java.util.Optional;

import com.cine.ejercicio.domain.Show;

public interface ShowService {
    List<Show> findAll();
    Optional<Show> findById(Long id);
    Show save(Show show);
    void deleteById(Long id);
}

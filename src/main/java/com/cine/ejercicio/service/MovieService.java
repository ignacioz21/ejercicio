package com.cine.ejercicio.service;


import java.util.List;
import java.util.Optional;

import com.cine.ejercicio.domain.Movie;

public interface MovieService {
    List<Movie> findAll();
    Optional<Movie> findById(Long id);
    Movie save(Movie movie);
    void deleteById(Long id);
}

package com.cine.ejercicio.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.ejercicio.dao.MovieDao;
import com.cine.ejercicio.domain.Movie;
import com.cine.ejercicio.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
    
    @Autowired
    private MovieDao movieDao;
    
    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }
    
    @Override
    public Optional<Movie> findById(Long id) {
        return movieDao.findById(id);
    }
    
    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }
    
    @Override
    public void deleteById(Long id) {
        movieDao.deleteById(id);
    }
}

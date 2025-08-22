package com.cine.ejercicio.service;


import java.util.List;
import java.util.Optional;

import com.cine.ejercicio.domain.User;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    Optional<User> findByUsername(String username);
    User save(User user);
    void deleteById(Long id);
}

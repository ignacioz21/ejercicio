package com.cine.ejercicio.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cine.ejercicio.dao.UserDao;
import com.cine.ejercicio.domain.User;
import com.cine.ejercicio.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
    
    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }
    
    @Override
    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
    
    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDao.save(user);
    }
    
    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
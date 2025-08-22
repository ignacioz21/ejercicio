package com.cine.ejercicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cine.ejercicio.domain.User;
import com.cine.ejercicio.service.UserService;

@SpringBootApplication
public class EjercicioApplication implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(EjercicioApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear usuario administrador por defecto si no existe
        if (userService.findByUsername("admin").isEmpty()) {
            User admin = new User("admin", "admin123", "admin@cinema.com", User.Role.ADMIN);
            userService.save(admin);
        }
        
        // Crear usuario regular por defecto si no existe
        if (userService.findByUsername("user").isEmpty()) {
            User user = new User("user", "user123", "user@cinema.com", User.Role.USER);
            userService.save(user);
        }
    }
}

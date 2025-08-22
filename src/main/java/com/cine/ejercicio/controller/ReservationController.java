package com.cine.ejercicio.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cine.ejercicio.domain.Reservation;
import com.cine.ejercicio.domain.User;
import com.cine.ejercicio.service.ReservationService;
import com.cine.ejercicio.service.ShowService;
import com.cine.ejercicio.service.UserService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @Autowired
    private ShowService showService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String myReservations(Model model, Authentication auth) {
        User user = userService.findByUsername(auth.getName()).orElse(null);
        if (user != null) {
            model.addAttribute("reservations", reservationService.findByUser(user));
        }
        return "reservations";
    }
    
    @PostMapping("/create")
    public String createReservation(@RequestParam Long showId, 
                                  @RequestParam Integer seats, 
                                  Authentication auth) {
        User user = userService.findByUsername(auth.getName()).orElse(null);
        showService.findById(showId).ifPresent(show -> {
            Reservation reservation = new Reservation();
            reservation.setUser(user);
            reservation.setShow(show);
            reservation.setSeats(seats);
            reservation.setReservationDate(LocalDateTime.now());
            reservation.setTotalPrice(show.getPrice() * seats);
            reservation.setStatus(Reservation.Status.ACTIVE);
            reservationService.save(reservation);
        });
        return "redirect:/reservations";
    }
    
    @PostMapping("/{id}/cancel")
    public String cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return "redirect:/reservations";
    }
}

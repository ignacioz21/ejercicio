package com.cine.ejercicio.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cine.ejercicio.dao.ReservatioDao;
import com.cine.ejercicio.domain.Reservation;
import com.cine.ejercicio.domain.User;
import com.cine.ejercicio.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {
    
    @Autowired
    private ReservatioDao reservationDao;
    
    @Override
    public List<Reservation> findAll() {
        return reservationDao.findAll();
    }
    
    @Override
    public List<Reservation> findByUser(User user) {
        return reservationDao.findByUser(user);
    }
    
    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationDao.findById(id);
    }
    
    @Override
    public Reservation save(Reservation reservation) {
        return reservationDao.save(reservation);
    }
    
    @Override
    public void cancelReservation(Long id) {
        Optional<Reservation> reservation = reservationDao.findById(id);
        if (reservation.isPresent()) {
            Reservation res = reservation.get();
            res.setStatus(Reservation.Status.CANCELLED);
            reservationDao.save(res);
        }
    }
}

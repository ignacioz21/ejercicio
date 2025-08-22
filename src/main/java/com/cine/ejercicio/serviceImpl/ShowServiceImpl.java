package com.cine.ejercicio.serviceImpl;

import com.cine.ejercicio.dao.ShowDao;
import com.cine.ejercicio.domain.Show;
import com.cine.ejercicio.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {
    
    @Autowired
    private ShowDao showDao;
    
    @Override
    public List<Show> findAll() {
        return showDao.findAll();
    }
    
    @Override
    public Optional<Show> findById(Long id) {
        return showDao.findById(id);
    }
    
    @Override
    public Show save(Show show) {
        return showDao.save(show);
    }
    
    @Override
    public void deleteById(Long id) {
        showDao.deleteById(id);
    }
}

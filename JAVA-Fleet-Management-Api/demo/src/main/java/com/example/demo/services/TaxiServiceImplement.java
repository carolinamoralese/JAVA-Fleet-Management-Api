package com.example.demo.services;

import com.example.demo.dao.TaxiDao;
import com.example.demo.entity.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;


@Service
public class TaxiServiceImplement implements TaxiServices {

    @Autowired
    private TaxiDao taxiDao;

    @Override
    @Transactional(readOnly = true)
    public Page<Taxi> findAll(Pageable pageable) {
        return taxiDao.findAll(pageable);
    }

    @Override
    @Transactional
    public Taxi save(Taxi taxi) {
        return taxiDao.save(taxi);
    }

    @Override
    @Transactional
    public Taxi findById(Long id) {
        return taxiDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Taxi taxi) {
        taxiDao.delete(taxi);
    }
}

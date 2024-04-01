package com.example.demo.services;

import com.example.demo.entity.Taxi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TaxiServices {
    public Page<Taxi> findAll(Pageable pageable);

    public Taxi save(Taxi taxi);

    public Taxi findById(Long id);

    public void  delete(Taxi taxi);
}

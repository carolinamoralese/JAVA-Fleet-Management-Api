package com.example.demo.services;

import com.example.demo.entity.LastLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LastLocationService {
    public Page<LastLocation>findLastLocation(Pageable pageable);
}

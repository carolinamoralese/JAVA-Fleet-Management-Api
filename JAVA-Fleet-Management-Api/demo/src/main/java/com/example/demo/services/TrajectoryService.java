package com.example.demo.services;
import com.example.demo.entity.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;


public interface TrajectoryService {
    public Page<Trajectory> findByDateAndTaxiId(LocalDate date, Long taxi_id, Pageable pageable);
}

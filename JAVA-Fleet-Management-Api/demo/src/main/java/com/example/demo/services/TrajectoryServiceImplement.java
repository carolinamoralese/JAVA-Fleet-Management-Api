package com.example.demo.services;

import com.example.demo.dao.TrajectoryDao;

import com.example.demo.entity.Trajectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
public class TrajectoryServiceImplement implements  TrajectoryService {
    @Autowired
    private TrajectoryDao trajectoryDao;

    @Override
    @Transactional
    public Page<Trajectory> findByDateAndTaxiId(LocalDate date, Long taxi_id, Pageable pageable) {
        return  trajectoryDao.findByDateAndTaxiId(date,taxi_id,pageable);
    }
}

package com.example.demo.dao;

import com.example.demo.entity.Trajectory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface TrajectoryDao extends JpaRepository <Trajectory, Long>{
    Page<Trajectory> findByDateAndTaxiId(LocalDate date, Long taxi_id, Pageable pageable);
}

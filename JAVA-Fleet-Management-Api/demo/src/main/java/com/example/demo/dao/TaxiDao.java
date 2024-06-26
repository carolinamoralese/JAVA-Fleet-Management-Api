package com.example.demo.dao;

import com.example.demo.entity.Taxi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiDao extends JpaRepository<Taxi, Long> {
}

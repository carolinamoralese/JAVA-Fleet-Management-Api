package com.example.demo.dao;

import com.example.demo.entity.LastLocation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastLocationDao extends JpaRepository<LastLocation, Integer> {
    @Query(value = "SELECT DISTINCT ON (taxis.id) taxis.id, taxis.plate, trajectories.date, trajectories.latitude, trajectories.longitude " +
            "FROM taxis " +
            "JOIN trajectories ON taxis.id = trajectories.taxi_id " +
            "ORDER BY taxis.id, trajectories.date DESC",
            nativeQuery = true)
    Page<Object[]> findLastLocations(Pageable pageable);
}

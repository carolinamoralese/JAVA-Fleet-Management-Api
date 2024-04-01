package com.example.demo.services;

import com.example.demo.dao.LastLocationDao;
import com.example.demo.entity.LastLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;

@Service
public class LastLocationServiceImplement implements LastLocationService {
    @Autowired
    private LastLocationDao lastLocationDao;

    public Page<LastLocation> findLastLocation(Pageable pageable) {
        Page<Object[]> lastLocations = lastLocationDao.findLastLocations(pageable);

        return lastLocations.map(row -> new LastLocation(
                (Integer) row[0], // id
                (String) row[1], // plate
                ((Date) row[2]).toLocalDate(), // date
                (Double) row[3], // latitude
                (Double) row[4] // longitude
        ));
    }
}
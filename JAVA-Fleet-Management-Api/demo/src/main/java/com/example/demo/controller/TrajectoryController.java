package com.example.demo.controller;

import com.example.demo.entity.Trajectory;
import com.example.demo.services.TrajectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class TrajectoryController {

    @Autowired
    private TrajectoryService trajectoryService;

    @GetMapping(value="/trajectories")
    public ResponseEntity<Object> getById(
            @RequestParam("date") LocalDate date,
            @RequestParam("taxi_id") Long taxi_id,
            Pageable pageable){

            try {
                Page<Trajectory> page = trajectoryService.findByDateAndTaxiId(
                        date,
                        taxi_id,
                        pageable);
                return new ResponseEntity<Object>(page, HttpStatus.OK);

            }
            catch (Exception e) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("message", e.getMessage());
                return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
            }
    }
}

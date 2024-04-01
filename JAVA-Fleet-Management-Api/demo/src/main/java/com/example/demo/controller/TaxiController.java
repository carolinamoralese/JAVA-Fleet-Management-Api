package com.example.demo.controller;

import com.example.demo.entity.Taxi;
import com.example.demo.services.TaxiServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class TaxiController {

    @Autowired
    private TaxiServices taxiServices;

    @GetMapping(value = "/taxis")
    public ResponseEntity<Object> get(Pageable pageable) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Page<Taxi> page = taxiServices.findAll(pageable);

            return new ResponseEntity<Object>(page, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value="/taxis/{id}")
    public ResponseEntity<Object> getById(@PathVariable Long id){
        try {
            Taxi data  = taxiServices.findById(id);
            return new ResponseEntity<Object>(data,HttpStatus.OK);
        }
        catch (Exception e) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/taxis")
    public ResponseEntity<Object> create(@RequestBody Taxi taxi){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Taxi res = taxiServices.save(taxi);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/taxis/{id}")
    public ResponseEntity<Object> update(@RequestBody Taxi taxi, @PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Taxi currentTaxi = taxiServices.findById(id);
            currentTaxi.setPlate(taxi.getPlate());
            Taxi res = taxiServices.save(taxi);
            return new ResponseEntity<Object>(res,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/taxis/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Taxi currentTaxi = taxiServices.findById(id);
            taxiServices.delete(currentTaxi);
            map.put("deleted", true);
            return new ResponseEntity<Object>(map,HttpStatus.OK);
        }
        catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>( map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

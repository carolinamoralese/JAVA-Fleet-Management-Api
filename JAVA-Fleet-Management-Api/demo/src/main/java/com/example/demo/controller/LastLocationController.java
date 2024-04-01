package com.example.demo.controller;
import com.example.demo.entity.LastLocation;
import com.example.demo.services.LastLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class LastLocationController {
    @Autowired
    private LastLocationService lastLocationService;

    @GetMapping("/last-locations")
    public ResponseEntity<Object> lastLocation(Pageable pageable) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Page<LastLocation> page = lastLocationService.findLastLocation(pageable);
            return new ResponseEntity<Object>(page, HttpStatus.OK);
        } catch (Exception e) {
            map.put("message", e.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
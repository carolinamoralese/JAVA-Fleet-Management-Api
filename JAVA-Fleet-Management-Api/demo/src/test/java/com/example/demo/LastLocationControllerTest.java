package com.example.demo;


import com.example.demo.controller.LastLocationController;
import com.example.demo.entity.LastLocation;
import com.example.demo.services.LastLocationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LastLocationControllerTest {

    @Mock
    private LastLocationService lastLocationService;

    @InjectMocks
    private LastLocationController lastLocationController;

    @Test
    void testLastLocation() {
        // Mock para la paginación
        Pageable pageable = Pageable.unpaged();

        // Crear una lista de LastLocation vacía
        Page<LastLocation> emptyPage = new PageImpl<>(Collections.emptyList());

        // Simular el servicio devolviendo una lista vacía
        when(lastLocationService.findLastLocation(pageable)).thenReturn(emptyPage);

        // Llamar al método del controlador
        ResponseEntity<Object> responseEntity = lastLocationController.lastLocation(pageable);

        // Verificar que la respuesta sea un HTTP 200 OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que la respuesta contenga una lista vacía
        Page<LastLocation> responsePage = (Page<LastLocation>) responseEntity.getBody();
        assertEquals(0, responsePage.getTotalElements());
    }
}

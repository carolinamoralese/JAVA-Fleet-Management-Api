package com.example.demo;


import com.example.demo.controller.TaxiController;
import com.example.demo.entity.Taxi;
import com.example.demo.services.TaxiServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaxiControllerTest {

    @Mock
    private TaxiServices taxiServices;

    @InjectMocks
    private TaxiController taxiController;

    @Test
    void testGetAllTaxis() {
        // Mock para la paginación
        Pageable pageable = Pageable.unpaged();

        // Crear una lista de Taxis vacía
        Page<Taxi> emptyPage = Page.empty();

        // Simular el servicio devolviendo una lista vacía
        when(taxiServices.findAll(pageable)).thenReturn(emptyPage);

        // Llamar al método del controlador
        ResponseEntity<Object> responseEntity = taxiController.get(pageable);

        // Verificar que la respuesta sea un HTTP 200 OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que la respuesta contenga una lista vacía de Taxis
        Page<Taxi> responsePage = (Page<Taxi>) responseEntity.getBody();
        assertEquals(0, responsePage.getTotalElements());
    }

    // Aquí puedes agregar más tests para los otros métodos del controlador (getById, create, update, delete)
}

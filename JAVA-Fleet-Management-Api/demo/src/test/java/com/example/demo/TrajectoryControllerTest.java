package com.example.demo;


import com.example.demo.controller.TrajectoryController;
import com.example.demo.entity.Trajectory;
import com.example.demo.services.TrajectoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrajectoryControllerTest {

    @Mock
    private TrajectoryService trajectoryService;

    @InjectMocks
    private TrajectoryController trajectoryController;

    @Test
    void testGetByDateAndTaxiId() {
        // Parámetros de prueba
        LocalDate date = LocalDate.now();
        Long taxiId = 1L;
        Pageable pageable = Pageable.unpaged();

        // Crear una página vacía de Trajectory
        Page<Trajectory> emptyPage = Page.empty();

        // Simular el servicio devolviendo una página vacía
        when(trajectoryService.findByDateAndTaxiId(date, taxiId, pageable)).thenReturn(emptyPage);

        // Llamar al método del controlador
        ResponseEntity<Object> responseEntity = trajectoryController.getById(date, taxiId, pageable);

        // Verificar que la respuesta sea un HTTP 200 OK
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        // Verificar que la respuesta contenga una lista vacía de Trajectories
        Page<Trajectory> responsePage = (Page<Trajectory>) responseEntity.getBody();
        assertEquals(0, responsePage.getTotalElements());
    }

    // Puedes agregar más tests para otros casos de prueba según sea necesario
}

package com.example.demo;

import com.example.demo.dao.LastLocationDao;
import com.example.demo.entity.LastLocation;

import com.example.demo.services.LastLocationServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LastLocationServiceTest {

    @Mock
    private LastLocationDao lastLocationDao;

    @InjectMocks
    private LastLocationServiceImplement lastLocationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindLastLocation() {
        // Representación de la solicitud de una página de datos paginada
        int page = 0;
        int size = 10;
        PageRequest pageable = PageRequest.of(page, size);

        // Se configura que el DAO devuelva una lista vacía de datos simulados paginados
        List<Object[]> testData = new ArrayList<>();
        Page<Object[]> mockedPage = new PageImpl<>(testData, pageable, testData.size());
        when(lastLocationDao.findLastLocations(pageable)).thenReturn(mockedPage);

        // Llamada al método bajo prueba
        Page<LastLocation> result = lastLocationService.findLastLocation(pageable);

        // Verificaciones
        Assertions.assertNotNull(result); // Se espera que el resultado no sea nulo
        Assertions.assertEquals(testData.size(), result.getContent().size()); // Se espera que el tamaño sea igual entre el simulado y obtenido
    }
}

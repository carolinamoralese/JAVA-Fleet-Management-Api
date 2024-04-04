package com.example.demo;

import com.example.demo.dao.TaxiDao;
import com.example.demo.entity.Taxi;
import com.example.demo.services.TaxiServiceImplement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TaxiServiceTest {

    @Mock
    private TaxiDao taxiDao;

    @InjectMocks
    private TaxiServiceImplement taxiService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        Page<Taxi> expectedPage = new PageImpl<>(Collections.singletonList(new Taxi()));
        when(taxiDao.findAll(any(Pageable.class))).thenReturn(expectedPage);

        Page<Taxi> result = taxiService.findAll(Pageable.unpaged());

        assertEquals(expectedPage, result);
    }

    @Test
    void testSave() {

        Taxi taxi = new Taxi();
        taxi.setId(1);
        taxi.setPlate("ABC123");

        when(taxiDao.save(taxi)).thenReturn(taxi);

        Taxi savedTaxi = taxiService.save(taxi);


        assertEquals(taxi, savedTaxi);
    }

    @Test
    void testFindById() {

        Taxi taxi = new Taxi();
        taxi.setId(1);
        taxi.setPlate("ABC123");


        when(taxiDao.findById(1L)).thenReturn(Optional.of(taxi));


        Taxi result = taxiService.findById(1L);


        assertEquals(taxi, result);
    }

    @Test
    void testDelete() {

        Taxi taxi = new Taxi();
        taxi.setId(1);
        taxi.setPlate("ABC123");


        taxiService.delete(taxi);


        verify(taxiDao).delete(taxi);
    }
}

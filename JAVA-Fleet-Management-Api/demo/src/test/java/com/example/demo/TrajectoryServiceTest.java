package com.example.demo;

import com.example.demo.dao.TrajectoryDao;
import com.example.demo.entity.Trajectory;
import com.example.demo.services.TrajectoryServiceImplement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TrajectoryServiceTest {

    @Mock
    private TrajectoryDao trajectoryDao;

    @InjectMocks
    private TrajectoryServiceImplement trajectoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindByDateAndTaxiId_shouldReturnEmptyPage_whenNoDataFound() {
        // Arrange
        Page<Trajectory> emptyPage = Page.empty();
        when(trajectoryDao.findByDateAndTaxiId(any(LocalDate.class), any(Long.class), any(Pageable.class)))
                .thenReturn(emptyPage);

        // Act
        LocalDate date = LocalDate.of(2023, 12, 31);
        Long taxiId = 123L;
        Page<Trajectory> result = trajectoryService.findByDateAndTaxiId(date, taxiId, Pageable.unpaged());

        // Assert
        assertEquals(emptyPage, result);
    }

    @Test
    public void testFindByDateAndTaxiId_shouldReturnData_whenDataExists() {
        // Arrange
        List<Trajectory> mockData = Collections.singletonList(new Trajectory());
        Page<Trajectory> mockPage = new PageImpl<>(mockData);
        when(trajectoryDao.findByDateAndTaxiId(any(LocalDate.class), any(Long.class), any(Pageable.class)))
                .thenReturn(mockPage);

        // Act
        LocalDate date = LocalDate.of(2024, 2, 22);
        Long taxiId = 456L;
        Page<Trajectory> result = trajectoryService.findByDateAndTaxiId(date, taxiId, Pageable.unpaged());

        // Assert
        assertEquals(mockPage, result);
    }
}

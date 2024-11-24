package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;


public class DegreeServiceTest {

    @Mock
    private DegreeRepository degreeRepository;

    @InjectMocks
    private DegreeService degreeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDegree() {
        Degrees degree = objectToTest();
        when(degreeRepository.save(any(Degrees.class))).thenReturn(degree);
        Degrees result = degreeService.create(degree);

        assertNotNull(result);
        assertEquals(degree.getId(), result.getId());
        verify(degreeRepository, times(1)).save(any(Degrees.class));
    }

    @Test
    void findAll_ReturnsListOfDegrees() {
        List<Degrees> degrees = Arrays.asList(objectToTest(), new Degrees());
        when(degreeRepository.findAll()).thenReturn(degrees);

        List<Degrees> result = degreeService.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(degreeRepository, times(1)).findAll();
    }

    @Test
    void getById_WhenExists_ReturnsDegree() {
        when(degreeRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));

        Optional<Degrees> result = degreeService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(objectToTest().getId(), result.get().getId());
        verify(degreeRepository, times(1)).findById(1L);
    }

    @Test
    void getById_WhenNotExists_ReturnsEmpty() {
        when(degreeRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Degrees> result = degreeService.getById(99L);

        assertTrue(result.isEmpty());
        verify(degreeRepository, times(1)).findById(99L);
    }

    @Test
    void update_WhenExists_UpdatesDegree() {
        Degrees updatedDegree = new Degrees();
        updatedDegree.setId(1L);

        when(degreeRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        when(degreeRepository.save(any(Degrees.class))).thenReturn(updatedDegree);

        Degrees result = degreeService.update(1L, updatedDegree);

        assertNotNull(result);
        assertEquals(updatedDegree.getId(), result.getId());
        verify(degreeRepository, times(1)).findById(1L);
        verify(degreeRepository, times(1)).save(any(Degrees.class));
    }

    @Test
    void update_WhenNotExists_ThrowsException() {
        when(degreeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> degreeService.update(99L, new Degrees())
        );

        verify(degreeRepository, times(1)).findById(99L);
        verify(degreeRepository, never()).save(any(Degrees.class));
    }

    @Test
    void delete_WhenExists_DeletesDegree() {

        Degrees degreeToDelete = objectToTest();

        when(degreeRepository.findById(1L)).thenReturn(Optional.of(degreeToDelete));

        when(degreeRepository.save(degreeToDelete)).thenReturn(degreeToDelete);

        degreeService.delete(1L);

        verify(degreeRepository, times(1)).findById(1L);
        verify(degreeRepository, times(1)).save(degreeToDelete);
    }

    @Test
    void delete_WhenNotExists_ThrowsException() {
        when(degreeRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> degreeService.delete(99L));

        verify(degreeRepository, times(1)).findById(99L);
        verify(degreeRepository, never()).deleteById(any());
    }


    public Degrees objectToTest() {
        Degrees degree = new Degrees();
        degree.setId(1L);
        return degree;
    }
}

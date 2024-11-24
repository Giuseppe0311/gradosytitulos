package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.repository.ProgramRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.never;

public class ProgramServiceTest {

    @Mock
    private ProgramRepository programRepository;

    @InjectMocks
    private ProgramService programService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDegree() {
        Programs programs = objectToTest();
        when(programRepository.save(any(Programs.class))).thenReturn(programs);
        Programs result = programService.create(programs);

        assertNotNull(result);
        assertEquals(programs.getId(), result.getId());
        verify(programRepository, times(1)).save(any(Programs.class));
    }

    @Test
    void findAll_ReturnsListOfDegrees() {
        List<Programs> programs = Arrays.asList(objectToTest(), new Programs());
        when(programRepository.findAll()).thenReturn(programs);

        List<Programs> result = programRepository.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(programRepository, times(1)).findAll();
    }

    @Test
    void getById_WhenExists_ReturnsDegree() {
        when(programRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));

        Optional<Programs> result = programService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(objectToTest().getId(), result.get().getId());
        verify(programRepository, times(1)).findById(1L);
    }

    @Test
    void getById_WhenNotExists_ReturnsEmpty() {
        when(programRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Programs> result = programService.getById(99L);

        assertTrue(result.isEmpty());
        verify(programRepository, times(1)).findById(99L);
    }

    @Test
    void update_WhenExists_UpdatesDegree() {
        Programs updatedPrograms = new Programs();
        updatedPrograms.setId(1L);

        when(programRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        when(programRepository.save(any(Programs.class))).thenReturn(updatedPrograms);

        Programs result = programService.update(1L, updatedPrograms);

        assertNotNull(result);
        assertEquals(updatedPrograms.getId(), result.getId());
        verify(programRepository, times(1)).findById(1L);
        verify(programRepository, times(1)).save(any(Programs.class));
    }

    @Test
    void update_WhenNotExists_ThrowsException() {
        when(programRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> programService.update(99L, new Programs())
        );

        verify(programRepository, times(1)).findById(99L);
        verify(programRepository, never()).save(any(Programs.class));
    }

    @Test
    void delete_WhenExists_Program() {
        Programs programs = objectToTest();
        when(programRepository.findById(1L)).thenReturn(Optional.of(programs));
        when(programRepository.save(programs)).thenReturn(programs);

        programService.delete(1L);

        verify(programRepository, times(1)).findById(1L);
        verify(programRepository, times(1)).save(programs);
    }

    @Test
    void delete_WhenNotExists_ThrowsException() {
        when(programRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> programService.delete(99L));

        verify(programRepository, times(1)).findById(99L);
        verify(programRepository, never()).deleteById(any());
    }


    public Programs objectToTest() {
        Programs programs = new Programs();
        programs.setId(1L);
        return programs;
    }
}

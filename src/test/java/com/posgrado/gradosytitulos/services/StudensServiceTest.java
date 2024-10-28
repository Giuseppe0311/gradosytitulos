package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Programs;
import com.posgrado.gradosytitulos.domain.Students;
import com.posgrado.gradosytitulos.repository.StudentRepository;
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

public class StudensServiceTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentsService studentsService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDegree(){
        Students students = objectToTest();
        when(studentRepository.save(any(Students.class))).thenReturn(students);
        Students result = studentsService.create(students);

        assertNotNull(result);
        assertEquals(students.getId(), result.getId());
        verify(studentRepository, times(1)).save(any(Students.class));
    }
    @Test
    void findAll_ReturnsListOfDegrees() {
        List<Students> programs = Arrays.asList(objectToTest(), new Students());
        when(studentRepository.findAll()).thenReturn(programs);
        List<Students> result = studentRepository.findAll();
        assertNotNull(result);
        assertEquals(2, result.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void getById_WhenExists_ReturnsDegree() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));

        Optional<Students> result = studentsService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(objectToTest().getId(), result.get().getId());
        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void getById_WhenNotExists_ReturnsEmpty() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Students> result = studentsService.getById(99L);

        assertTrue(result.isEmpty());
        verify(studentRepository, times(1)).findById(99L);
    }

    @Test
    void update_WhenExists_UpdatesDegree() {
        Students updatedStuents = new Students();
        updatedStuents.setId(1L);

        when(studentRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        when(studentRepository.save(any(Students.class))).thenReturn(updatedStuents);

        Students result = studentsService.update(1L, updatedStuents);

        assertNotNull(result);
        assertEquals(updatedStuents.getId(), result.getId());
        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(any(Students.class));
    }

    @Test
    void update_WhenNotExists_ThrowsException() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> studentsService.update(99L, new Students()));

        verify(studentRepository, times(1)).findById(99L);
        verify(studentRepository, never()).save(any(Students.class));
    }

    @Test
    void delete_WhenExists_DeletesDegree() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        doNothing().when(studentRepository).deleteById(1L);

        studentsService.delete(1L);

        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).deleteById(1L);
    }

    @Test
    void delete_WhenNotExists_ThrowsException() {
        when(studentRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> studentsService.delete(99L));

        verify(studentRepository, times(1)).findById(99L);
        verify(studentRepository, never()).deleteById(any());
    }


    public Students objectToTest(){
        Students students = new Students();
        students.setId(1L);
        return students;
    }
}

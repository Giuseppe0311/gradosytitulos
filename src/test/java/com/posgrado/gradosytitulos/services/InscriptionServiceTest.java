package com.posgrado.gradosytitulos.services;

import com.posgrado.gradosytitulos.domain.Degrees;
import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.repository.DegreeRepository;
import com.posgrado.gradosytitulos.repository.InscriptionRepository;
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

public class InscriptionServiceTest {
    @Mock
    private InscriptionRepository inscriptionRepository;

    @InjectMocks
    private InscriptionService inscriptionService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createDegree(){
        Inscriptions inscriptions = objectToTest();
        when(inscriptionRepository.save(any(Inscriptions.class))).thenReturn(inscriptions);
        Inscriptions result = inscriptionService.create(inscriptions);

        assertNotNull(result);
        assertEquals(inscriptions.getId(), result.getId());
        verify(inscriptionRepository, times(1)).save(any(Inscriptions.class));
    }
    @Test
    void findAll_ReturnsListOfDegrees() {
        List<Inscriptions> inscriptions = Arrays.asList(objectToTest(), new Inscriptions());
        when(inscriptionRepository.findAll()).thenReturn(inscriptions);

        List<Inscriptions> result = inscriptionRepository.findAll();

        assertNotNull(result);
        assertEquals(2, result.size());
        verify(inscriptionRepository, times(1)).findAll();
    }

    @Test
    void getById_WhenExists_ReturnsDegree() {
        when(inscriptionRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));

        Optional<Inscriptions> result = inscriptionService.getById(1L);

        assertTrue(result.isPresent());
        assertEquals(objectToTest().getId(), result.get().getId());
        verify(inscriptionRepository, times(1)).findById(1L);
    }

    @Test
    void getById_WhenNotExists_ReturnsEmpty() {
        when(inscriptionRepository.findById(99L)).thenReturn(Optional.empty());

        Optional<Inscriptions> result = inscriptionService.getById(99L);

        assertTrue(result.isEmpty());
        verify(inscriptionRepository, times(1)).findById(99L);
    }

    @Test
    void update_WhenExists_UpdatesDegree() {
        Inscriptions updatedInscriptions = new Inscriptions();
        updatedInscriptions.setId(1L);

        when(inscriptionRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        when(inscriptionRepository.save(any(Inscriptions.class))).thenReturn(updatedInscriptions);

        Inscriptions result = inscriptionService.update(1L, updatedInscriptions);

        assertNotNull(result);
        assertEquals(updatedInscriptions.getId(), result.getId());
        verify(inscriptionRepository, times(1)).findById(1L);
        verify(inscriptionRepository, times(1)).save(any(Inscriptions.class));
    }

    @Test
    void update_WhenNotExists_ThrowsException() {
        when(inscriptionRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> inscriptionService.update(99L, new Inscriptions())
        );

        verify(inscriptionRepository, times(1)).findById(99L);
        verify(inscriptionRepository, never()).save(any(Inscriptions.class));
    }

    @Test
    void delete_WhenExists_DeletesDegree() {
        when(inscriptionRepository.findById(1L)).thenReturn(Optional.of(objectToTest()));
        doNothing().when(inscriptionRepository).deleteById(1L);

        inscriptionService.delete(1L);

        verify(inscriptionRepository, times(1)).findById(1L);
        verify(inscriptionRepository, times(1)).deleteById(1L);
    }

    @Test
    void delete_WhenNotExists_ThrowsException() {
        when(inscriptionRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NoSuchElementException.class, () -> inscriptionService.delete(99L));

        verify(inscriptionRepository, times(1)).findById(99L);
        verify(inscriptionRepository, never()).deleteById(any());
    }


    public Inscriptions objectToTest(){
        Inscriptions inscription = new Inscriptions();
        inscription.setId(1L);
        return inscription;
    }
}

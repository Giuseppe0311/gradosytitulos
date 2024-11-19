package com.posgrado.gradosytitulos.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.posgrado.gradosytitulos.domain.Inscriptions;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionCreate;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionUpdate;
import com.posgrado.gradosytitulos.dto.dto.Inscription.InscriptionView;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionCreateMapper;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionUpdateMapper;
import com.posgrado.gradosytitulos.dto.mappers.inscription.InscriptionViewMapper;
import com.posgrado.gradosytitulos.services.InscriptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class InscriptionControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InscriptionService inscriptionService;

    @MockBean
    private InscriptionViewMapper inscriptionViewMapper;

    @MockBean
    private InscriptionUpdateMapper inscriptionUpdateMapper;

    @MockBean
    private InscriptionCreateMapper inscriptionCreateMapper;


    @Test
    @WithMockUser(roles = "admin_client")
    void testGetAllInscriptions() throws Exception {
        InscriptionView inscriptionView = new InscriptionView(1L, null, null, null, null);
        Inscriptions inscriptions = new Inscriptions();
        when(inscriptionService.findAll()).thenReturn(List.of(inscriptions));
        when(inscriptionViewMapper.map(inscriptions)).thenReturn(inscriptionView);

        mockMvc.perform(get("/api/v1/inscription").content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

        verify(inscriptionService).findAll();
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testGetInscriptionById() throws Exception {
        InscriptionView inscriptionView = new InscriptionView(1L, null, null, null, null);
        Inscriptions inscriptions = new Inscriptions();
        Long id = 1L;
        when(inscriptionService.getById(id)).thenReturn(Optional.of(inscriptions));
        when(inscriptionViewMapper.map(inscriptions)).thenReturn(inscriptionView);

        mockMvc.perform(get("/api/v1/inscription/{id}", id).content(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));

        verify(inscriptionService).getById(id);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testSaveInscription() throws Exception {
        InscriptionView inscriptionView = new InscriptionView(1L, null, null, null, null);
        InscriptionCreate inscriptionCreate = new InscriptionCreate(
                null,
                null,
                null,
                null
        );
        Inscriptions inscriptions = new Inscriptions();
        when(inscriptionCreateMapper.map(inscriptionCreate)).thenReturn(inscriptions);
        when(inscriptionService.create(inscriptions)).thenReturn(inscriptions);
        when(inscriptionViewMapper.map(inscriptions)).thenReturn(inscriptionView);

        ObjectMapper objectMapper = new ObjectMapper();
        String inscriptionJson = objectMapper.writeValueAsString(inscriptionCreate);

        mockMvc.perform(post("/api/v1/inscription")
                        .content(inscriptionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isCreated());

        verify(inscriptionService).create(inscriptions);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testUpdateInscription() throws Exception {
        InscriptionView inscriptionView = new InscriptionView(1L, null, null, null, null);
        InscriptionUpdate inscriptionUpdate = new InscriptionUpdate(
                null,
                null,
                null,
                null
        );
        Inscriptions inscriptions = new Inscriptions();
        Long id = 1L;
        when(inscriptionUpdateMapper.map(inscriptionUpdate)).thenReturn(inscriptions);
        when(inscriptionService.update(id, inscriptions)).thenReturn(inscriptions);
        when(inscriptionViewMapper.map(inscriptions)).thenReturn(inscriptionView);

        ObjectMapper objectMapper = new ObjectMapper();
        String inscriptionJson = objectMapper.writeValueAsString(inscriptionUpdate);

        mockMvc.perform(put("/api/v1/inscription/{id}", id)
                        .content(inscriptionJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());

        verify(inscriptionService).update(id, inscriptions);
    }

    @Test
    @WithMockUser(roles = "admin_client")
    void testDeleteInscription() throws Exception {
        Long id = 1L;
        doNothing().when(inscriptionService).delete(id);

        mockMvc.perform(delete("/api/v1/inscription/delete/{id}", id))
                .andExpect(status().isNoContent());

        verify(inscriptionService).delete(id);
    }

}

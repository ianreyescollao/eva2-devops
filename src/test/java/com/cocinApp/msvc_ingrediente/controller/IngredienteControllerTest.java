package com.cocinApp.msvc_ingrediente.controller;

import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.service.IngredienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredienteControllerTest {

    @Mock
    private IngredienteService ingredienteService;

    @InjectMocks
    private IngredienteController ingredienteController;

    // GET - Traer todos los ingredientes
    @Test
    void traerIngrediente_Retorna200() {

        IngredienteDTO ingrediente = new IngredienteDTO();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("Papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        when(ingredienteService.traerIngrediente())
                .thenReturn(List.of(ingrediente));

        ResponseEntity<List<IngredienteDTO>> respuesta =
                ingredienteController.traerIngrediente();

        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals(1, respuesta.getBody().size());
        assertEquals("Papa", respuesta.getBody().get(0).getNombreIngrediente());

        verify(ingredienteService, times(1)).traerIngrediente();
    }

    // GET - Buscar ingrediente por ID
    @Test
    void buscarIngredientePorId_Retorna200() {

        IngredienteDTO ingrediente = new IngredienteDTO();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("Papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        when(ingredienteService.buscarIngredientePorId(1L))
                .thenReturn(ingrediente);

        ResponseEntity<IngredienteDTO> respuesta =
                ingredienteController.buscarIngredientePorId(1L);

        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals(1L, respuesta.getBody().getIdIngrediente());
        assertEquals("Papa", respuesta.getBody().getNombreIngrediente());

        verify(ingredienteService, times(1))
                .buscarIngredientePorId(1L);
    }

    // POST - Crear ingrediente
    @Test
    void crearIngrediente_Retorna201() {

        IngredienteDTO ingrediente = new IngredienteDTO();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("Papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        when(ingredienteService.crearIngrediente(ingrediente))
                .thenReturn(ingrediente);

        ResponseEntity<IngredienteDTO> respuesta =
                ingredienteController.crearIngrediente(ingrediente);

        assertEquals(201, respuesta.getStatusCode().value());
        assertEquals(1L, respuesta.getBody().getIdIngrediente());
        assertEquals("Papa", respuesta.getBody().getNombreIngrediente());

        verify(ingredienteService, times(1))
                .crearIngrediente(ingrediente);
    }

    // PUT - Actualizar ingrediente
    @Test
    void actualizarIngrediente_Retorna200() {

        IngredienteDTO ingrediente = new IngredienteDTO();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("Papa Actualizada");
        ingrediente.setPrecioEstandarIngrediente(900.0);
        ingrediente.setPrecioExtraIngrediente(600.0);

        when(ingredienteService.actualizarIngrediente(1L, ingrediente))
                .thenReturn(ingrediente);

        ResponseEntity<IngredienteDTO> respuesta =
                ingredienteController.actualizarIngrediente(ingrediente, 1L);

        assertEquals(200, respuesta.getStatusCode().value());
        assertEquals(1L, respuesta.getBody().getIdIngrediente());
        assertEquals(
                "Papa Actualizada",
                respuesta.getBody().getNombreIngrediente()
        );

        verify(ingredienteService, times(1))
                .actualizarIngrediente(1L, ingrediente);
    }

    // DELETE - Eliminar ingrediente
    @Test
    void eliminarIngrediente_Retorna204() {

        doNothing()
                .when(ingredienteService)
                .eliminarIngrediente(1L);

        ResponseEntity<Void> respuesta =
                ingredienteController.eliminarIngrediente(1L);

        assertEquals(204, respuesta.getStatusCode().value());

        verify(ingredienteService, times(1))
                .eliminarIngrediente(1L);
    }
}
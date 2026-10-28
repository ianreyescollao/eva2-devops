package com.cocinApp.msvc_ingrediente.service;

import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.exception.NotFoundException;
import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import com.cocinApp.msvc_ingrediente.repository.IngredienteRepository;
import com.cocinApp.msvc_ingrediente.service.impl.IngredienteServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class IngredienteServiceImplTest {

    @Mock
    private IngredienteRepository repo;

    @InjectMocks
    private IngredienteServiceImpl service;

    @Test
    void traerIngrediente_DTO() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        when(repo.findAll()).thenReturn(List.of(ingrediente));

        List<IngredienteDTO> resultado = service.traerIngrediente();

        assertEquals(1, resultado.size());
        assertEquals("papa", resultado.get(0).getNombreIngrediente());
        assertEquals(800.0, resultado.get(0).getPrecioEstandarIngrediente());
        assertEquals(500.0, resultado.get(0).getPrecioExtraIngrediente());

        verify(repo, times(1)).findAll();
    }

    @Test
    void buscarIngredientePorId_DTO() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        when(repo.findById(1L)).thenReturn(Optional.of(ingrediente));

        IngredienteDTO resultado = service.buscarIngredientePorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdIngrediente());
        assertEquals("papa", resultado.getNombreIngrediente());

        verify(repo, times(1)).findById(1L);
    }

    @Test
    void buscarIngredientePorId_NotFoundException() {
        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            service.buscarIngredientePorId(99L);
        });

        verify(repo, times(1)).findById(99L);
    }

    @Test
    void crearIngrediente_DTO() {
        IngredienteDTO dto = new IngredienteDTO();
        dto.setNombreIngrediente("papa");
        dto.setPrecioEstandarIngrediente(800.0);
        dto.setPrecioExtraIngrediente(500.0);

        Ingrediente ingredienteGuardado = new Ingrediente();
        ingredienteGuardado.setIdIngrediente(1L);
        ingredienteGuardado.setNombreIngrediente("papa");
        ingredienteGuardado.setPrecioEstandarIngrediente(800.0);
        ingredienteGuardado.setPrecioExtraIngrediente(500.0);

        when(repo.save(any(Ingrediente.class))).thenReturn(ingredienteGuardado);

        IngredienteDTO resultado = service.crearIngrediente(dto);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getIdIngrediente());
        assertEquals("papa", resultado.getNombreIngrediente());

        verify(repo, times(1)).save(any(Ingrediente.class));
    }

    @Test
    void actualizarIngrediente_DTO() {
        Ingrediente ingredienteExistente = new Ingrediente();
        ingredienteExistente.setIdIngrediente(1L);
        ingredienteExistente.setNombreIngrediente("papa");
        ingredienteExistente.setPrecioEstandarIngrediente(800.0);
        ingredienteExistente.setPrecioExtraIngrediente(500.0);

        IngredienteDTO dtoActualizado = new IngredienteDTO();
        dtoActualizado.setNombreIngrediente("arroz");
        dtoActualizado.setPrecioEstandarIngrediente(1000.0);
        dtoActualizado.setPrecioExtraIngrediente(700.0);

        when(repo.findById(1L)).thenReturn(Optional.of(ingredienteExistente));
        when(repo.save(any(Ingrediente.class))).thenReturn(ingredienteExistente);

        IngredienteDTO resultado = service.actualizarIngrediente(1L, dtoActualizado);

        assertEquals("arroz", resultado.getNombreIngrediente());
        assertEquals(1000.0, resultado.getPrecioEstandarIngrediente());
        assertEquals(700.0, resultado.getPrecioExtraIngrediente());

        verify(repo, times(1)).findById(1L);
        verify(repo, times(1)).save(ingredienteExistente);
    }

    @Test
    void actualizarIngrediente_NotFoundException() {
        IngredienteDTO dto = new IngredienteDTO();

        when(repo.findById(99L)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> {
            service.actualizarIngrediente(99L, dto);
        });

        verify(repo, times(1)).findById(99L);
        verify(repo, never()).save(any(Ingrediente.class));
    }

    @Test
    void eliminarIngrediente() {
        when(repo.existsById(1L)).thenReturn(true);

        service.eliminarIngrediente(1L);

        verify(repo, times(1)).existsById(1L);
        verify(repo, times(1)).deleteById(1L);
    }

    @Test
    void eliminarIngrediente_NotFoundException() {
        when(repo.existsById(30L)).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            service.eliminarIngrediente(30L);
        });

        verify(repo, times(1)).existsById(30L);
        verify(repo, never()).deleteById(anyLong());
    }
}
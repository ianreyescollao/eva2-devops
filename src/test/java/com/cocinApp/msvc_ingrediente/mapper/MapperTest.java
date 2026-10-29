package com.cocinApp.msvc_ingrediente.mapper;

import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapperTest {

    // Ingrediente -> IngredienteDTO
    @Test
    void toDtoIngrediente_RetornaIngredienteDTO() {

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setIdIngrediente(1L);
        ingrediente.setNombreIngrediente("Papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        IngredienteDTO dto = Mapper.toDto(ingrediente);

        assertNotNull(dto);
        assertEquals(1L, dto.getIdIngrediente());
        assertEquals("Papa", dto.getNombreIngrediente());
        assertEquals(800.0, dto.getPrecioEstandarIngrediente());
        assertEquals(500.0, dto.getPrecioExtraIngrediente());
    }

    // Ingrediente null -> retorna null
    @Test
    void toDtoIngredienteNull_RetornaNull() {
        IngredienteDTO resultado = Mapper.toDto((Ingrediente) null);
        assertNull(resultado);
    }
}
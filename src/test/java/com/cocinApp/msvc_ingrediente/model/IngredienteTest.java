package com.cocinApp.msvc_ingrediente.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredienteTest {

    private Ingrediente ingrediente;

    @BeforeEach
    void setUp() {
        ingrediente = new Ingrediente();
    }

    @Test
    void testGetSetIdIngrediente() {
        ingrediente.setIdIngrediente(1L);
        assertEquals(1L, ingrediente.getIdIngrediente());
    }

    @Test
    void testGetSetNombreIngrediente() {
        ingrediente.setNombreIngrediente("Papa");
        assertEquals("Papa", ingrediente.getNombreIngrediente());
    }

    @Test
    void testGetSetPrecioEstandar() {
        ingrediente.setPrecioEstandarIngrediente(800.0);
        assertEquals(800.0, ingrediente.getPrecioEstandarIngrediente());
    }

    @Test
    void testGetSetPrecioExtra() {
        ingrediente.setPrecioExtraIngrediente(500.0);
        assertEquals(500.0, ingrediente.getPrecioExtraIngrediente());
    }

    @Test
    void testNuevoIngredienteTieneCamposNulos() {
        assertNull(ingrediente.getIdIngrediente());
        assertNull(ingrediente.getNombreIngrediente());
        assertNull(ingrediente.getPrecioEstandarIngrediente());
        assertNull(ingrediente.getPrecioExtraIngrediente());
    }
}
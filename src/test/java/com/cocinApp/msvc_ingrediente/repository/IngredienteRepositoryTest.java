package com.cocinApp.msvc_ingrediente.repository;

import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class IngredienteRepositoryTest {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    // Guardar ingrediente
    @Test
    void guardarIngrediente() {

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombreIngrediente("Papa");
        ingrediente.setPrecioEstandarIngrediente(800.0);
        ingrediente.setPrecioExtraIngrediente(500.0);

        Ingrediente guardado = ingredienteRepository.save(ingrediente);

        assertNotNull(guardado.getIdIngrediente());
        assertEquals("Papa", guardado.getNombreIngrediente());
        assertEquals(800.0, guardado.getPrecioEstandarIngrediente());
        assertEquals(500.0, guardado.getPrecioExtraIngrediente());
    }

    // Buscar ingrediente por ID
    @Test
    void buscarIngredientePorId() {

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombreIngrediente("Tomate");
        ingrediente.setPrecioEstandarIngrediente(1000.0);
        ingrediente.setPrecioExtraIngrediente(600.0);

        Ingrediente guardado = ingredienteRepository.save(ingrediente);

        Optional<Ingrediente> encontrado =
                ingredienteRepository.findById(guardado.getIdIngrediente());

        assertTrue(encontrado.isPresent());
        assertEquals("Tomate", encontrado.get().getNombreIngrediente());
    }

    // Listar ingredientes
    @Test
    void listarIngredientes() {

        Ingrediente ingrediente1 = new Ingrediente();
        ingrediente1.setNombreIngrediente("Papa");
        ingrediente1.setPrecioEstandarIngrediente(800.0);
        ingrediente1.setPrecioExtraIngrediente(500.0);

        Ingrediente ingrediente2 = new Ingrediente();
        ingrediente2.setNombreIngrediente("Tomate");
        ingrediente2.setPrecioEstandarIngrediente(1000.0);
        ingrediente2.setPrecioExtraIngrediente(600.0);

        ingredienteRepository.save(ingrediente1);
        ingredienteRepository.save(ingrediente2);

        List<Ingrediente> ingredientes =
                ingredienteRepository.findAll();

        assertEquals(2, ingredientes.size());
    }

    // Eliminar ingrediente
    @Test
    void eliminarIngrediente() {

        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setNombreIngrediente("Cebolla");
        ingrediente.setPrecioEstandarIngrediente(700.0);
        ingrediente.setPrecioExtraIngrediente(400.0);

        Ingrediente guardado = ingredienteRepository.save(ingrediente);

        ingredienteRepository.deleteById(guardado.getIdIngrediente());

        Optional<Ingrediente> eliminado =
                ingredienteRepository.findById(guardado.getIdIngrediente());

        assertTrue(eliminado.isEmpty());
    }
}
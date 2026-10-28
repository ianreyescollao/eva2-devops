package com.cocinApp.msvc_ingrediente.service;


import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;

import java.util.List;


public interface IngredienteService {
    List<IngredienteDTO> traerIngrediente();
    IngredienteDTO buscarIngredientePorId(Long id);
    IngredienteDTO crearIngrediente(IngredienteDTO ingredienteDTO);
    IngredienteDTO actualizarIngrediente( Long id, IngredienteDTO ingredienteDTO);
    void eliminarIngrediente(Long id);
}

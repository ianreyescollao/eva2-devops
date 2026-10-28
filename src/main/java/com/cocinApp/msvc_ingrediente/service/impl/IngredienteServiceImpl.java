package com.cocinApp.msvc_ingrediente.service.impl;


import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.exception.NotFoundException;
import com.cocinApp.msvc_ingrediente.mapper.Mapper;
import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import com.cocinApp.msvc_ingrediente.repository.IngredienteRepository;
import com.cocinApp.msvc_ingrediente.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServiceImpl implements IngredienteService {

    @Autowired
    private IngredienteRepository repo;

    @Override
    public List<IngredienteDTO> traerIngrediente() {
        return repo.findAll().stream().map(Mapper::toDto).toList();
    }

    @Override
    public IngredienteDTO buscarIngredientePorId(Long id) {
        Ingrediente ingre = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingrediente no encontrado"));
        return Mapper.toDto(ingre);
    }

    @Override
    public IngredienteDTO crearIngrediente(IngredienteDTO iDto) {
        Ingrediente ingre =  new Ingrediente();
                ingre.setNombreIngrediente(iDto.getNombreIngrediente());
                ingre.setPrecioEstandarIngrediente(iDto.getPrecioEstandarIngrediente());
                ingre.setPrecioExtraIngrediente(iDto.getPrecioExtraIngrediente());

        return Mapper.toDto(repo.save(ingre));
    }

    @Override
    public IngredienteDTO actualizarIngrediente(Long id, IngredienteDTO iDTO) {
        Ingrediente ingre = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Ingrediente no encontrado"));
                ingre.setNombreIngrediente(iDTO.getNombreIngrediente());
                ingre.setPrecioEstandarIngrediente(iDTO.getPrecioEstandarIngrediente());
                ingre.setPrecioExtraIngrediente(iDTO.getPrecioExtraIngrediente());
                return Mapper.toDto(repo.save(ingre));
    }

    @Override
    public void eliminarIngrediente(Long id) {
        if (!repo.existsById(id)){
            throw new NotFoundException("Ingrediente no encontrado para eliminar");
        }
        repo.deleteById(id);
    }
}

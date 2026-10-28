package com.cocinApp.msvc_ingrediente.mapper;

import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.dto.LoteIngredienteDTO;
import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import com.cocinApp.msvc_ingrediente.model.LoteIngrediente;

public class Mapper {

    public static IngredienteDTO toDto(Ingrediente i) {
        if (i == null) return null;

        return IngredienteDTO.builder()
                .idIngrediente(i.getIdIngrediente())
                .nombreIngrediente(i.getNombreIngrediente())
                .precioEstandarIngrediente(i.getPrecioEstandarIngrediente())
                .precioExtraIngrediente(i.getPrecioExtraIngrediente())
                .build();
    }

    public static LoteIngredienteDTO toDto(LoteIngrediente lote) {
        if (lote == null) return null;

        return new LoteIngredienteDTO(
                lote.getIdLote(),
                lote.getIngrediente().getIdIngrediente(),
                lote.getStock(),
                lote.getFechaIngreso(),
                lote.getFechaVencimiento()
        );
    }
}
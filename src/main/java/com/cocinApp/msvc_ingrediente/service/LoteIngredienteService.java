package com.cocinApp.msvc_ingrediente.service;

import com.cocinApp.msvc_ingrediente.dto.LoteIngredienteDTO;

import java.util.List;

public interface LoteIngredienteService {

    LoteIngredienteDTO crearLote(Long idIngrediente, LoteIngredienteDTO loteDTO);

    List<LoteIngredienteDTO> listarLotesPorIngrediente(Long idIngrediente);

    Double obtenerStockTotal(Long idIngrediente);

    List<LoteIngredienteDTO> listarLotesVencidos();

    List<LoteIngredienteDTO> listarLotesPorVencer(Integer dias);
}
package com.cocinApp.msvc_ingrediente.service.impl;

import com.cocinApp.msvc_ingrediente.dto.LoteIngredienteDTO;
import com.cocinApp.msvc_ingrediente.exception.NotFoundException;
import com.cocinApp.msvc_ingrediente.mapper.Mapper;
import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import com.cocinApp.msvc_ingrediente.model.LoteIngrediente;
import com.cocinApp.msvc_ingrediente.repository.IngredienteRepository;
import com.cocinApp.msvc_ingrediente.repository.LoteIngredienteRepository;
import com.cocinApp.msvc_ingrediente.service.LoteIngredienteService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoteIngredienteServiceImpl implements LoteIngredienteService {

    private final LoteIngredienteRepository loteRepo;
    private final IngredienteRepository ingredienteRepo;

    public LoteIngredienteServiceImpl(LoteIngredienteRepository loteRepo,
                                      IngredienteRepository ingredienteRepo) {
        this.loteRepo = loteRepo;
        this.ingredienteRepo = ingredienteRepo;
    }

    @Override
    public LoteIngredienteDTO crearLote(Long idIngrediente, LoteIngredienteDTO loteDTO) {
        Ingrediente ingrediente = ingredienteRepo.findById(idIngrediente)
                .orElseThrow(() -> new NotFoundException("Ingrediente no encontrado"));

        LoteIngrediente lote = new LoteIngrediente();
        lote.setIngrediente(ingrediente);
        lote.setStock(loteDTO.getStock());
        lote.setFechaIngreso(
                loteDTO.getFechaIngreso() != null ? loteDTO.getFechaIngreso() : LocalDate.now()
        );
        lote.setFechaVencimiento(loteDTO.getFechaVencimiento());

        return Mapper.toDto(loteRepo.save(lote));
    }

    @Override
    public List<LoteIngredienteDTO> listarLotesPorIngrediente(Long idIngrediente) {
        if (!ingredienteRepo.existsById(idIngrediente)) {
            throw new NotFoundException("Ingrediente no encontrado");
        }

        return loteRepo.findByIngredienteIdIngrediente(idIngrediente)
                .stream()
                .map(Mapper::toDto)
                .toList();
    }

    @Override
    public Double obtenerStockTotal(Long idIngrediente) {
        if (!ingredienteRepo.existsById(idIngrediente)) {
            throw new NotFoundException("Ingrediente no encontrado");
        }

        return loteRepo.findByIngredienteIdIngrediente(idIngrediente)
                .stream()
                .mapToDouble(lote -> lote.getStock() != null ? lote.getStock() : 0.0)
                .sum();
    }

    @Override
    public List<LoteIngredienteDTO> listarLotesVencidos() {
        return loteRepo.findByFechaVencimientoBefore(LocalDate.now())
                .stream()
                .map(Mapper::toDto)
                .toList();
    }

    @Override
    public List<LoteIngredienteDTO> listarLotesPorVencer(Integer dias) {
        LocalDate hoy = LocalDate.now();
        LocalDate limite = hoy.plusDays(dias);

        return loteRepo.findByFechaVencimientoBetween(hoy, limite)
                .stream()
                .map(Mapper::toDto)
                .toList();
    }
}
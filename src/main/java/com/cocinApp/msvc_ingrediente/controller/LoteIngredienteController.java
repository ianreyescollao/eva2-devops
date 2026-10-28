package com.cocinApp.msvc_ingrediente.controller;

import com.cocinApp.msvc_ingrediente.dto.LoteIngredienteDTO;
import com.cocinApp.msvc_ingrediente.service.LoteIngredienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class LoteIngredienteController {

    private final LoteIngredienteService loteIngredienteService;

    public LoteIngredienteController(LoteIngredienteService loteIngredienteService) {
        this.loteIngredienteService = loteIngredienteService;
    }

    @PostMapping("/{idIngrediente}/lotes")
    public ResponseEntity<LoteIngredienteDTO> crearLote(
            @PathVariable Long idIngrediente,
            @RequestBody LoteIngredienteDTO loteDTO) {

        return ResponseEntity.ok(loteIngredienteService.crearLote(idIngrediente, loteDTO));
    }

    @GetMapping("/{idIngrediente}/lotes")
    public ResponseEntity<List<LoteIngredienteDTO>> listarLotesPorIngrediente(
            @PathVariable Long idIngrediente) {

        return ResponseEntity.ok(loteIngredienteService.listarLotesPorIngrediente(idIngrediente));
    }

    @GetMapping("/{idIngrediente}/stock")
    public ResponseEntity<Double> obtenerStockTotal(
            @PathVariable Long idIngrediente) {

        return ResponseEntity.ok(loteIngredienteService.obtenerStockTotal(idIngrediente));
    }

    @GetMapping("/lotes/vencidos")
    public ResponseEntity<List<LoteIngredienteDTO>> listarLotesVencidos() {
        return ResponseEntity.ok(loteIngredienteService.listarLotesVencidos());
    }

    @GetMapping("/lotes/por-vencer")
    public ResponseEntity<List<LoteIngredienteDTO>> listarLotesPorVencer(
            @RequestParam(defaultValue = "7") Integer dias) {

        return ResponseEntity.ok(loteIngredienteService.listarLotesPorVencer(dias));
    }
}
package com.cocinApp.msvc_ingrediente.controller;

import com.cocinApp.msvc_ingrediente.dto.IngredienteDTO;
import com.cocinApp.msvc_ingrediente.service.IngredienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService ingredienteService;

    @GetMapping
    public ResponseEntity<List<IngredienteDTO>> traerIngrediente(){
        return ResponseEntity.ok(ingredienteService.traerIngrediente());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IngredienteDTO> buscarIngredientePorId(@PathVariable Long id){
        return ResponseEntity.ok(ingredienteService.buscarIngredientePorId(id));
    }

    @PostMapping
    public ResponseEntity<IngredienteDTO> crearIngrediente(@RequestBody IngredienteDTO iDto){
        IngredienteDTO ingre = ingredienteService.crearIngrediente(iDto);
        return ResponseEntity.created(URI.create("/ingredientes/" + ingre.getIdIngrediente())).body(ingre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IngredienteDTO> actualizarIngrediente(@RequestBody IngredienteDTO iDto , @PathVariable Long id){
        return ResponseEntity.ok(ingredienteService.actualizarIngrediente(id,iDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIngrediente(@PathVariable Long id){
        ingredienteService.eliminarIngrediente(id);
        return ResponseEntity.noContent().build();
    }
}

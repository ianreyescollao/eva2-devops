package com.cocinApp.msvc_ingrediente.repository;

import com.cocinApp.msvc_ingrediente.model.LoteIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LoteIngredienteRepository extends JpaRepository<LoteIngrediente, Long> {

    List<LoteIngrediente> findByIngredienteIdIngrediente(Long idIngrediente);

    List<LoteIngrediente> findByFechaVencimientoBefore(LocalDate fecha);

    List<LoteIngrediente> findByFechaVencimientoBetween(LocalDate desde, LocalDate hasta);
}
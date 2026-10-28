package com.cocinApp.msvc_ingrediente.repository;

import com.cocinApp.msvc_ingrediente.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredienteRepository extends JpaRepository<Ingrediente,Long> {
}

package com.cocinApp.msvc_ingrediente.dto;

import java.time.LocalDate;

public class LoteIngredienteDTO {

    private Long idLote;
    private Long idIngrediente;
    private Double stock;
    private LocalDate fechaIngreso;
    private LocalDate fechaVencimiento;

    public LoteIngredienteDTO() {
    }

    public LoteIngredienteDTO(Long idLote, Long idIngrediente, Double stock, LocalDate fechaIngreso, LocalDate fechaVencimiento) {
        this.idLote = idLote;
        this.idIngrediente = idIngrediente;
        this.stock = stock;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Double getStock() {
        return stock;
    }

    public void setStock(Double stock) {
        this.stock = stock;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
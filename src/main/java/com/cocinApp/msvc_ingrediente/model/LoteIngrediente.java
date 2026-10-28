package com.cocinApp.msvc_ingrediente.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "lote_ingrediente")
public class LoteIngrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lote_ingrediente_seq")
    @SequenceGenerator(name = "lote_ingrediente_seq", sequenceName = "LOTE_INGREDIENTE_SEQ", allocationSize = 1)
    @Column(name = "id_lote")
    private Long idLote;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente", nullable = false)
    private Ingrediente ingrediente;

    @Column(name = "stock", nullable = false)
    private Double stock;

    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    public LoteIngrediente() {
    }

    public LoteIngrediente(Long idLote, Ingrediente ingrediente, Double stock, LocalDate fechaIngreso, LocalDate fechaVencimiento) {
        this.idLote = idLote;
        this.ingrediente = ingrediente;
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

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
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
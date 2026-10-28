package com.cocinApp.msvc_ingrediente.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingredientes")
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingrediente_seq")
    @SequenceGenerator(name = "ingrediente_seq", sequenceName = "INGREDIENTES_SEQ", allocationSize = 1)
    @Column(name = "id_ingrediente")
    private Long idIngrediente;

    @Column(name = "nombre")
    private String nombreIngrediente;

    @Column(name = "precio_estandar")
    private Double precioEstandarIngrediente;

    @Column(name = "precio_extra")
    private Double precioExtraIngrediente;

    @OneToMany(mappedBy = "ingrediente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LoteIngrediente> lotes = new ArrayList<>();

    public Ingrediente() {
    }


  public Ingrediente(Long idIngrediente, String nombreIngrediente, Double precioEstandarIngrediente, Double precioExtraIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.precioEstandarIngrediente = precioEstandarIngrediente;
        this.precioExtraIngrediente = precioExtraIngrediente;
    }

    public Long getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Long idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    public Double getPrecioEstandarIngrediente() {
        return precioEstandarIngrediente;
    }

    public void setPrecioEstandarIngrediente(Double precioEstandarIngrediente) {
        this.precioEstandarIngrediente = precioEstandarIngrediente;
    }

    public Double getPrecioExtraIngrediente() {
        return precioExtraIngrediente;
    }

    public void setPrecioExtraIngrediente(Double precioExtraIngrediente) {
        this.precioExtraIngrediente = precioExtraIngrediente;
    }

    public List<LoteIngrediente> getLotes() {
        return lotes;
    }

    public void setLotes(List<LoteIngrediente> lotes) {
        this.lotes = lotes;
    }
}
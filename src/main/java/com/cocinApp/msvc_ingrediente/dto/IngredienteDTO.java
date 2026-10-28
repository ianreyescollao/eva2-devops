package com.cocinApp.msvc_ingrediente.dto;


public class IngredienteDTO {

    private Long idIngrediente;
    private String nombreIngrediente;
    private Double precioEstandarIngrediente;
    private Double precioExtraIngrediente;

    public IngredienteDTO() {
    }

    public IngredienteDTO(Long idIngrediente, String nombreIngrediente, Double precioEstandarIngrediente, Double precioExtraIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nombreIngrediente = nombreIngrediente;
        this.precioEstandarIngrediente = precioEstandarIngrediente;
        this.precioExtraIngrediente = precioExtraIngrediente;
    }
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long idIngrediente;
        private String nombreIngrediente;
        private Double precioEstandarIngrediente;
        private Double precioExtraIngrediente;

        public Builder idIngrediente(Long idIngrediente) {
            this.idIngrediente = idIngrediente;
            return this;
        }

        public Builder nombreIngrediente(String nombreIngrediente) {
            this.nombreIngrediente = nombreIngrediente;
            return this;
        }

        public Builder precioEstandarIngrediente(Double precioEstandarIngrediente) {
            this.precioEstandarIngrediente = precioEstandarIngrediente;
            return this;
        }

        public Builder precioExtraIngrediente(Double precioExtraIngrediente) {
            this.precioExtraIngrediente = precioExtraIngrediente;
            return this;
        }

        public IngredienteDTO build() {
            return new IngredienteDTO(
                    idIngrediente,
                    nombreIngrediente,
                    precioEstandarIngrediente,
                    precioExtraIngrediente
            );
        }
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
}

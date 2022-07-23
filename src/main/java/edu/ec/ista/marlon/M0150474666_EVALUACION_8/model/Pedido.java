package edu.ec.ista.marlon.M0150474666_EVALUACION_8.model;

import javax.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "tip_medicamento", nullable = false, length = 45)
    private String tipMedicamento;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "distribuidor", nullable = false, length = 45)
    private String distribuidor;

    @Column(name = "sucursal", nullable = false, length = 45)
    private String sucursal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipMedicamento() {
        return tipMedicamento;
    }

    public void setTipMedicamento(String tipMedicamento) {
        this.tipMedicamento = tipMedicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

}
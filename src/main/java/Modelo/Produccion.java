/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author halla
 */
public class Produccion implements Serializable {

    private int idProduccion;
    private String empleado;
    private int cantidad;
    public Producto producto;
    public Estado estado;
    private String fechaInicio;
    private String fechaFin;

    public int getIdProduccion() {
        return idProduccion;
    }

    public void setIdProduccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public enum Estado {
        Finalizado, Proceso
    };

    public enum Producto {
        Bandejas, Cajones, Palets
    };

    public Produccion() {
    }

    public Produccion(int idProduccion) {
        this.idProduccion = idProduccion;
    }

    public Produccion(int idProduccion, String empleado) {
        this.idProduccion = idProduccion;
        this.empleado = empleado;
    }

    public Produccion(int idProduccion, String empleado, int cantidad, Producto producto, Estado estado, String fechaInicio, String fechaFin) {
        this.idProduccion = idProduccion;
        this.empleado = empleado;
        this.cantidad = cantidad;
        this.producto = producto;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Produccion{" + "idProduccion=" + idProduccion + ", empleado=" + empleado + ", cantidad=" + cantidad + ", producto=" + producto + ", estado=" + estado + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }

}

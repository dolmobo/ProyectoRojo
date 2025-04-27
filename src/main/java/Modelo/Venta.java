/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;


public class Venta implements Serializable{

    private int idVenta;
    private String nombre;  
    private int cantidad;
    private float precio;  
    private String vendedor;  
    private String fechaVenta;
    private float precioFinal;
    private int iva;

    // Constructor

    public Venta() {
    }
    
    public Venta(String nombre, int cantidad, float precio, String vendedor) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.vendedor = vendedor;
    }

    public Venta(int idVenta, String nombre, int cantidad, float precio, String vendedor, String fechaVenta, float precioFinal, int iva) {
        this.idVenta = idVenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.vendedor = vendedor;
        this.fechaVenta = fechaVenta;
        this.precioFinal = precioFinal;
        this.iva = iva;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(float precioFinal) {
        this.precioFinal = precioFinal;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", vendedor=" + vendedor + ", fechaVenta=" + fechaVenta + ", precioFinal=" + precioFinal + ", iva=" + iva + '}';
    }
    
    
    
}




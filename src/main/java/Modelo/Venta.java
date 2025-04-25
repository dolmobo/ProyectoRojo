/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Venta {

    private int idVenta;
    private String nombre;  // Renombrado de 'idCliente'
    private int cantidad;
    private float precio;  // Nuevo campo para el precio
    private String vendedor;  // Renombrado de 'estado'
    private String fechaVenta;
    
    private static List<Venta> ventas = new ArrayList<>(); // Simulando una base de datos en memoria

    // Constructor
    public Venta(int idVenta, String nombre, int cantidad, float precio, String vendedor, String fechaVenta) {
        this.idVenta = idVenta;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.vendedor = vendedor;
        this.fechaVenta = fechaVenta;
    }

    // Getters y Setters
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

    // Método para insertar una nueva venta
    public static void insertarVenta(Venta venta) {
        ventas.add(venta);
        System.out.println("Venta añadida: " + venta.toString());
    }

    // Método para eliminar una venta por su ID
    public static void eliminarVenta(int idVenta) {
        for (Venta v : ventas) {
            if (v.getIdVenta() == idVenta) {
                ventas.remove(v);
                System.out.println("Venta eliminada: " + v.toString());
                return;
            }
        }
        System.out.println("Venta con ID " + idVenta + " no encontrada.");
    }

    // Método para obtener todas las ventas
    public static List<Venta> obtenerVentas() {
        return ventas;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", vendedor='" + vendedor + '\'' +
                ", fechaVenta='" + fechaVenta + '\'' +
                '}';
    }
}




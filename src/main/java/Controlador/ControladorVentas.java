/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileTemplates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Venta;
import Usos.ConexionBDR;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * 
 * @author Jramirez
 */

public class ControladorVentas {

    // Añadir nueva venta
    //public void añadir(int idVenta, String nombre, int cantidad, float precio, String vendedor, int fechaVenta, float precioFinal, int iva) {
    public void añadir(Venta venta) {
    try {
        if (venta.getIdVenta() <= 0 
            || venta.getNombre() == null 
            || venta.getNombre().isEmpty()
            || venta.getCantidad() <= 0 
            || venta.getPrecio() <= 0 
            || venta.getVendedor() == null 
            || venta.getVendedor().isEmpty()
            || venta.getFechaVenta() == null 
            || venta.getPrecioFinal() <= 0 
            || venta.getIva() <= 0) {
                
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            
        } else {
            Connection con = new ConexionBDR().conectar();
            String sql = "INSERT INTO ventas (idVenta, nombre, cantidad, precio, vendedor, fechaVenta, precioFinal, iva) "
                    + "VALUES ("
                    + venta.getIdVenta() + ", '"
                    + venta.getNombre() + "', "
                    + venta.getCantidad() + ", "
                    + venta.getPrecio() + ", '"
                    + venta.getVendedor() + "', '"
                    + venta.getFechaVenta() + "', "
                    + venta.getPrecioFinal() + ", "
                    + venta.getIva() + ")";
                    
            Statement st = con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Venta añadida con éxito.");
        }
    } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al añadir la venta: " + e.getMessage());
    }
    }

    // Eliminar venta por ID
    public static void eliminar(int idVenta) {
        try {
            if (idVenta <= 0) {
                JOptionPane.showMessageDialog(null, "ID de venta no válido.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "DELETE FROM ventas WHERE idVenta = " + idVenta;
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Venta eliminada con éxito.");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage());
        }
    }

    // Editar información de una venta existente
    public static void editar(int idVenta, String nombre, int cantidad, float precio, String vendedor, int fechaVenta, float precioFinal, int iva) {
        try {
            if (idVenta <= 0 || nombre.isEmpty() || cantidad <= 0 || precio <= 0 || vendedor.isEmpty() || fechaVenta <= 0 || precioFinal <= 0 || iva <= 0) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE ventas SET nombre = '" + nombre + "', "
                        + "cantidad = " + cantidad + ", precio = " + precio + ", "
                        + "vendedor = '" + vendedor + "', fechaVenta = " + fechaVenta + ", "
                        + "precioFinal = " + precioFinal + ", iva = " + iva + " "
                        + "WHERE idVenta = " + idVenta;
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Venta modificada con éxito.");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al editar la venta: " + e.getMessage());
        }
    }

}

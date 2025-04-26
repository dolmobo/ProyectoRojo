/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Usos.ConexionBDR;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ControladorVentas {

    // Añadir nueva venta
    public static void añadir(int idVenta, String idCliente, String producto, int cantidad, String estado, String fechaVenta) {
        try {
            if (idCliente.equals("") || producto.equals("") || cantidad <= 0 || estado.equals("") || fechaVenta.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "INSERT INTO ventas(idVenta, idCliente, producto, cantidad, estado, fechaVenta) "
                        + "VALUES (" + idVenta + ", '" + idCliente + "', '" + producto + "', " + cantidad + ", '" + estado + "', '" + fechaVenta + "')";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Venta añadida con éxito.");
            }
        } catch (Exception e) {
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage());
        }
    }

    // Editar información de una venta existente
    public static void editar(int idVenta, String idCliente, String producto, int cantidad, String estado, String fechaVenta) {
        try {
            if (idCliente.equals("") || producto.equals("") || cantidad <= 0 || estado.equals("") || fechaVenta.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE ventas SET idCliente = '" + idCliente + "', producto = '" + producto + "', "
                        + "cantidad = " + cantidad + ", estado = '" + estado + "', fechaVenta = '" + fechaVenta + "' "
                        + "WHERE idVenta = " + idVenta;
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Venta modificada con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar la venta: " + e.getMessage());
        }
    }

    // Aquí podrías agregar más métodos para obtener datos de ventas, buscar ventas específicas, etc.
}







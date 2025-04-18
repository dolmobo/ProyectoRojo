/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Usos.ConexionBDR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class ControladorProducción {

    public static boolean añadir(String empleado, int cantidad, String estado, String fechaInicio, String fechaFin) {

        String sql = "INSERT INTO produccion (empleado_nombre, cantidad, estado, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = new ConexionBDR().conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado);
            ps.setInt(2, cantidad);
            ps.setString(3, estado);
            ps.setString(4, fechaInicio);
            ps.setString(5, fechaFin);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos:\n" + e.getMessage());
            return false;
        }
    }

    public static void eliminar(String empleado, int cantidad, String estado, String fechaInicio, String fechaFin) {
        if (empleado.isEmpty() || estado.isEmpty() || fechaInicio.isEmpty() || fechaFin.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            return;
        }

        String sql = "DELETE FROM produccion WHERE empleado = ? AND cantidad = ? AND estado = ? AND fecha_inicio = ? AND fecha_fin = ?";

        try (Connection con = new ConexionBDR().conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, empleado);
            ps.setInt(2, cantidad);
            ps.setString(3, estado);
            ps.setString(4, fechaInicio);
            ps.setString(5, fechaFin);

            int filasAfectadas = ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void eliminar(String nombre, String apellidos, String email, String direccion) {
        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("") || direccion.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "DELETE FROM clientes WHERE nombre = '" + nombre + "' AND apellidos = '" + apellidos
                        + "' AND email = '" + email + "' AND direccion = '" + direccion + "'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo empleado eliminado con exito.");
            }
        } catch (Exception e) {
        }
    }

}

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

    public static boolean añadir(String id, int cantidad, String producto, String estado, String fechaInicio, String fechaFin) {

        String sql = "INSERT INTO produccion (empleado_id, cantidad, producto, estado_f, fecha_inicio, fecha_fin) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = new ConexionBDR().conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, id);
            ps.setInt(2, cantidad);
            ps.setString(3, producto);
            ps.setString(4, estado);
            ps.setString(5, fechaInicio);
            ps.setString(6, fechaFin);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar en la base de datos:\n" + e.getMessage());
            return false;
        }
    }

    public static void eliminar(String idProduccion) {
        try {
            if (idProduccion.equals("")) {
                JOptionPane.showMessageDialog(null, "Falta el ID de producción.");
                return;  // Si el ID está vacío, salimos del método
            }

            Connection con = new ConexionBDR().conectar();
            // Crear la consulta SQL para eliminar la producción por idProduccion
            String sql = "DELETE FROM produccion WHERE id = '" + idProduccion + "'";

            Statement st = con.createStatement();
            st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Producción eliminada con éxito.");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la producción: " + e.getMessage());
            e.printStackTrace();  // Imprimir el error si ocurre
        }
    }
    
}

package Controlador;

import Modelo.Empleado;
import Usos.ConexionBDR;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ControladorEmpleados {

    /*
  Este método sirve para añadir a la BDR un nuevo empleado, usando
    una sentencia SQL.
     */
    public void añadir(Empleado empleado, String estado) {
        try {
            if (estado.isEmpty() || empleado.getNombre().isEmpty() || empleado.getPuesto().isEmpty()
                    || String.valueOf(empleado.getSalario()).isEmpty() || empleado.getFechaContratacion().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "INSERT INTO empleados (nombre, puesto, salario, fecha_contratacion, estado) VALUES ('"
                        + empleado.getNombre() + "', '"
                        + empleado.getPuesto() + "', '"
                        + empleado.getSalario() + "', '"
                        + empleado.getFechaContratacion() + "', '"
                        + estado + "')";

                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo empleado añadido con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir empleado: " + e.getMessage());
        }
    }

    /*
  Este método sirve para eliminar dentro de la BDR un empleado, usando
    una sentencia SQL.
     */
    public void eliminar(Empleado empleado) {
        try {
            if (empleado.getNombre().isEmpty() || empleado.getPuesto().isEmpty() || String.valueOf(empleado.getSalario()).isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "DELETE FROM empleados WHERE id = " + empleado.getId()
                        + " AND nombre = '" + empleado.getNombre()
                        + "' AND puesto = '" + empleado.getPuesto()
                        + "' AND salario = '" + empleado.getSalario() + "'";

                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado eliminado con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar empleado: " + e.getMessage());
        }
    }

    /*
  Este método sirve para modificar dentro de la BDR un empleado, usando
    una sentencia SQL.
     */
    public void editar(Empleado empleado, String estado) {
        try {
            if (estado.isEmpty() || empleado.getNombre().isEmpty() || empleado.getPuesto().isEmpty()
                    || String.valueOf(empleado.getSalario()).isEmpty() || empleado.getFechaContratacion().isEmpty()) {

                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE empleados SET nombre = '" + empleado.getNombre()
                        + "', puesto = '" + empleado.getPuesto()
                        + "', salario = '" + empleado.getSalario()
                        + "', fecha_contratacion = '" + empleado.getFechaContratacion()
                        + "', estado = '" + estado
                        + "' WHERE id = '" + empleado.getId() + "'";

                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Empleado modificado con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar empleado: " + e.getMessage());
        }
    }
}

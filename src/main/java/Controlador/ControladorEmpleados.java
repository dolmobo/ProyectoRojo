/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Usos.ConexionBDR;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class ControladorEmpleados {

        // Metodo añadir, con variables para pasar valores, desde el jframe.
        public static void añadir(String nombre, String puesto, String salario,String fechaContratacion, String estado) {
            try {
                // Si algun textField / variable, se encuentra vacio, avisara al usuario.
                if (estado.equals("") || nombre.equals("") || puesto.equals("") || salario.equals("")) {
                   JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
                } 

                else {
                    // Secuencia sql con la conexion para hacer la operacion con los ajustes del usuario.
                    Connection con = new ConexionBDR().conectar();
                    String sql = "INSERT INTO EMPLEADOS(nombre, puesto, salario,fecha_contratacion, estado) VALUES ('" 
                            + nombre + "', '" 
                            + puesto + "', '" 
                            + salario + "', '" 
                            + fechaContratacion + "', '"
                            + estado + "')";
                    
                    Statement st = con.createStatement();
                    // Ejecuta la actualizacion, de la secuencia sql.
                    st.executeUpdate(sql);
                    
                    // Mensaje de conseguido con exito.
                    JOptionPane.showMessageDialog(null, "Nuevo empleado añadido con exito.");
                }
            } catch (Exception e) {
            }
        }
    // Metodo eliminar, con variables para pasar valores, desde el jframe.
    public static void eliminar(String idStr,String nombre, String puesto, String salario) {
        try {
            // Si algun textField / variable, se encuentra vacio, avisara al usuario.
            if (nombre.equals("") || puesto.equals("") || salario.equals("")) {
               JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } 
            // Secuencia sql con la conexion para hacer la operacion con los ajustes del usuario.
            else {
                Connection con = new ConexionBDR().conectar();
                String sql = "DELETE FROM empleados WHERE id = " + idStr + 
                             " AND nombre = '" + nombre + "' AND puesto = '" + puesto + 
                             "' AND salario = '" + salario + "'";
                
                Statement st = con.createStatement();
                
                // Ejecuta la actualizacion, de la secuencia sql.
                st.executeUpdate(sql);
                
                // Mensaje de conseguido con exito.
                JOptionPane.showMessageDialog(null, "Nuevo empleado eliminado con exito.");
            }
        } catch (Exception e) {
        }
    }

    public static void editar(String idStr,String nombre, String puesto, String salario, String estado) {
        try {
            // Si algun textField / variable, se encuentra vacio, avisara al usuario.
            if (estado.equals("") || nombre.equals("") || puesto.equals("") || salario.equals("")) {
               JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } 
            
            else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE EMPLEADOS SET nombre = '" + nombre + "', puesto = '" + puesto + "', salario = '" + salario + "', estado = '" + estado + "' WHERE id = '" + idStr + "'";
                //String sql = "INSERT INTO EMPLEADOS(nombre, puesto, salario, estado) VALUES ('" + nombre + "', '" + puesto + "', '" + salario + "', '" + estado + "')";
                Statement st = con.createStatement();
                
                // Ejecuta la actualizacion, de la secuencia sql.
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo empleado modificado con exito.");
            }
        } catch (Exception e) {
        }
    }
   
}

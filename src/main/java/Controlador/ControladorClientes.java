/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Usos.ConexionBDR;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author aleja
 */
public class ControladorClientes {
        
        public static void añadir(String nombre, String apellidos, String email, String direccion) {
            try {
                if (nombre.equals("") || apellidos.equals("") || email.equals("") || direccion.equals("")) {
                   JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
                } 

                else {
                    Connection con = new ConexionBDR().conectar();
                    String sql = "INSERT INTO clientes(nombre, apellidos, email, direccion) VALUES ('" + nombre + "', '" + apellidos + "', '" + email + "', '" + direccion + "')";
                    Statement st = con.createStatement();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Nuevo empleado añadido con exito.");
                }
            } catch (Exception e) {
            }
        }   
        
     public static void eliminar(String idStr,String nombre, String apellidos, String email, String direccion) {
        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("") || direccion.equals("")) {
               JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } 
            
            else {
                Connection con = new ConexionBDR().conectar();
                 String sql = "DELETE FROM clientes WHERE id = " + idStr +
                     " AND nombre = '" + nombre + "'" +
                     " AND apellidos = '" + apellidos + "'" +
                     " AND email = '" + email + "'" +
                     " AND direccion = '" + direccion + "'";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo empleado eliminado con exito.");
            }
        } catch (Exception e) {
        }
    }

    public static void editar(String idStr,String nombre, String apellidos, String email, String direccion) {
        try {
            if (nombre.equals("") || apellidos.equals("") || email.equals("") || direccion.equals("")) {
               JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } 
            
            else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE clientes SET nombre = '" + nombre + "', apellidos = '" + apellidos + "', email = '" + email + "', direccion = '" + direccion + "' WHERE id = '" + idStr + "'";
                //String sql = "INSERT INTO EMPLEADOS(nombre, puesto, salario, estado) VALUES ('" + nombre + "', '" + puesto + "', '" + salario + "', '" + estado + "')";
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo empleado modificado con exito.");
            }
        } catch (Exception e) {
        }
    }      
    
    
    
    
    
}

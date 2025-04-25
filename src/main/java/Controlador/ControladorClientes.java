/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cliente;
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
        
    public void añadir(Cliente cliente) {
        try {
            if (cliente.getNombre().isEmpty() || cliente.getApellidos().isEmpty() 
                || cliente.getTelefono().isEmpty() || cliente.getEmail().isEmpty()
                || cliente.getDireccion().isEmpty())
            
            {
                
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "INSERT INTO clientes (nombre, apellidos, telefono, email, direccion) VALUES ('"
                        + cliente.getNombre() + "', '"
                        + cliente.getApellidos() + "', '"
                        + cliente.getTelefono() + "', '"
                        + cliente.getEmail()+ "', '"
                        + cliente.getDireccion()+ "')";
                
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Nuevo cliente añadido con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al añadir cliente: " + e.getMessage());
        }
    }   
        
    public void eliminar(Cliente cliente) {
        try {
            if (cliente.getNombre().isEmpty() || cliente.getApellidos().isEmpty() 
                || cliente.getTelefono().isEmpty() || cliente.getEmail().isEmpty()
                || cliente.getDireccion().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "DELETE FROM clientes WHERE id = " + cliente.getId()+
                             " AND nombre = '" + cliente.getNombre() +
                             "' AND apellidos = '" + cliente.getApellidos()+
                             "' AND telefono = '" + cliente.getTelefono()+
                             "' AND email = '" + cliente.getEmail()+
                             "' AND direccion = '" + cliente.getDireccion()+ "'";
                
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente eliminado con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el cliente: " + e.getMessage());
        }
    }

    public static void editar(Cliente cliente) {
        try {
            if (cliente.getNombre().isEmpty() || cliente.getApellidos().isEmpty() 
                || cliente.getTelefono().isEmpty() || cliente.getEmail().isEmpty()
                || cliente.getDireccion().isEmpty()) {
                
                JOptionPane.showMessageDialog(null, "Faltan datos por ingresar.");
            } else {
                Connection con = new ConexionBDR().conectar();
                String sql = "UPDATE clientes SET nombre = '" + cliente.getNombre() +
                             "', apellidos = '" + cliente.getApellidos() +
                             "', telefono = '" + cliente.getTelefono() +
                             "', email = '" + cliente.getEmail() +
                             "', direccion = '" + cliente.getDireccion() +
                             "' WHERE id = '" + cliente.getId() + "'";
                
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Cliente modificado con éxito.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al editar el cliente: " + e.getMessage());
        }
    }      
    
    
    
    
    
}

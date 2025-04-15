/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usos;

/**
 *
 * @author USUARIO
 */
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String password;

    // Constructor
    public User(String nombreUsuario, String contraseña) {
        this.username = nombreUsuario;
        this.password = contraseña;
    }

    // Getters y Setters
    public String getNombreUsuario() {
        return username;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.username = nombreUsuario;
    }

    public String getContraseña() {
        return password;
    }

    public void setContraseña(String contraseña) {
        this.password = contraseña;
    }
}

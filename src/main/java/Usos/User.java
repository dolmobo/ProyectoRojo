package Usos;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String username;
    private String password;
    private String rol; // Campo nuevo

    // Constructor

    public User(String username, String password, String rol) {
        this.username = username;
        this.password = password;
        this.rol = rol;
    }
    
    public User(String nombreUsuario, String contraseña) {
        this.username = nombreUsuario;
        this.password = contraseña;
        this.rol = "usuario"; 
    }

    public User() {}

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}

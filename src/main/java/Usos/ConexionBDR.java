package Usos;

// Falta algo???
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBDR {
    // Variables de conexión
    private Connection con;
    private Statement sentencia;
    private String usuario = "root";
    private String clave = "";
    private String url = "jdbc:mysql://localhost:3306/prueba3";  // Asegúrate de que el nombre de la base de datos sea correcto

    // Método para establecer la conexión
        public Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión establecida con " + url);
            return con;  // Retorna la conexión
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;  // Retorna null si falla la conexión
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        ConexionBDR conexion = new ConexionBDR();
        conexion.conectar();  // Llamamos al método conectar
    }
}

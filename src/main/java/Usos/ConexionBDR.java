package Usos;

// Falta algo???
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    private String usuario = "";
    private String clave = "";
    private String url = "";  // Asegúrate de que el nombre de la base de datos sea correcto

   
    
    // Método para establecer la conexión

    public ConexionBDR() {
        
        leerFicheroConfiguracion();
    }
    
        public Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexión establecida con " + url);
            return con;  
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            return null;  
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        ConexionBDR conexion = new ConexionBDR();
        
        
        conexion.conectar();  // Llamamos al método conectar    
    }
    
     public void leerFicheroConfiguracion() {
    String archivo = "configuracion.txt";  // Asumimos que está en la raíz del proyecto
    String linea;
    String[] partes;

    System.out.println("\nLEYENDO CONTENIDO DEL ARCHIVO '" + archivo + "':\n");

    try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
        while ((linea = br.readLine()) != null) {
            partes = linea.split(";");
            if (partes.length < 2) continue;

            switch (partes[0].toLowerCase()) {
                case "usuario":
                    usuario = partes[1];
                    break;
                case "clave":
                    clave = partes[1];
                    break;
                case "url":
                    url = partes[1];
                    break;
            }
        }
    } catch (IOException e) {
        System.out.println("Error leyendo el archivo: " + e.getMessage());
    }

    System.out.println("Datos leídos:");
    System.out.println("Usuario: " + usuario);
    System.out.println("Clave: " + clave);
    System.out.println("URL: " + url);
}

    
    
    
    
    
}

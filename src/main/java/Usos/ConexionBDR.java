package Usos;

// Falta algo???
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBDR {

    // Variables de conexión
    private Connection con;
    private Statement sentencia;
    private String usuario = "root";
    private String clave = "";
    private String url = "jdbc:mysql://localhost:3306/prueba5";  // Asegúrate de que el nombre de la base de datos sea correcto

    // Método para establecer la conexión
    public ConexionBDR() {

        leerFicheroConfiguracion();
    }

    public Connection conectar() {
        try {
            Connection con = DriverManager.getConnection(url, usuario, clave);
            System.out.println("\nConexión establecida con " + url);
            return con;
        } catch (SQLException e) {
            System.err.println("\tError de conexión: " + e.getMessage());
            return null;
        }
    }

    // Método principal para probar la conexión
    public static void main(String[] args) {
        ConexionBDR conexion = new ConexionBDR();

        conexion.conectar();  // Llamamos al método conectar
    }

    /*
  Este método sirve para leer la configuración y el contenido del fichero 
    donde se encuentran las credenciales de inicio de sesión.
     */    
    
    public void leerFicheroConfiguracion() {
        String linea;
        String[] partes;
        String nombreFichero = "configuracion.txt"; // Ruta relativa

        System.out.println("\nLEYENDO CONTENIDO DEL ARCHIVO '" + nombreFichero + "':\n");

        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            while ((linea = br.readLine()) != null) {
                partes = linea.split(";", 2);
                if (partes.length == 2) {
                    switch (partes[0].trim().toLowerCase()) {
                        case "usuario":
                            usuario = partes[1].trim();
                            break;
                        case "clave":
                            clave = partes[1].trim();
                            break;
                        case "url":
                            url = partes[1].trim();
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error leyendo el archivo de configuración: " + e.getMessage());
        }

        System.out.println("Datos leídos:");
        System.out.println("\tUsuario: " + usuario);
        System.out.println("\tClave: " + clave);
        System.out.println("\tURL: " + url);
    }

}

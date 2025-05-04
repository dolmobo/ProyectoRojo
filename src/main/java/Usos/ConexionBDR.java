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

    /*
  Este método sirve para leer la configuración y el contenido del fichero 
    donde se encuentran las credenciales de inicio de sesión.
     */    
    
    public void leerFicheroConfiguracion() {
        String cadena, nombreFich = "\\configuracion.txt";
        String cadenaTroceada[];

        System.out.println("\nLEYENDO CONTENIDO DEL ARCHIVO '" + nombreFich + "':\n");
        try (BufferedReader fichBuf = new BufferedReader(new FileReader(nombreFich))) {
            cadena = fichBuf.readLine();
            while (cadena != null) {
                //System.out.println(cadena);

                // Extracción de los datos
                cadenaTroceada = cadena.split(";");
                if (cadenaTroceada[0].equalsIgnoreCase("usuario")) {
                    usuario = cadenaTroceada[1];
                } else if (cadenaTroceada[0].equalsIgnoreCase("clave")) {
                    clave = cadenaTroceada[1];
                } else if (cadenaTroceada[0].equalsIgnoreCase("url")) {
                    url = cadenaTroceada[1];
                }

                cadena = fichBuf.readLine();
            }
            // se cierra el archivo
            fichBuf.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Datos leídos:");
        System.out.println("Usuario: " + usuario);
        System.out.println("Clave: " + clave);
        System.out.println("url:" + url);

    }

}

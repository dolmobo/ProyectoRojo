/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;

public class Leer {

    /**
     * @param mensaje
     * @return
     * @throws IOException
     */

    public static String leerTelefono(String mensaje) throws IOException {
        String telefono = null;

        try {
            InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
            BufferedReader teclado = new BufferedReader(flujo);
            boolean lecturaCorrecta = false;
            boolean emailOK;

            // mientras no se tenga al menos 1 letra y haya espacios en blaco, repetimos
            do {
                System.out.print("Introduce tu tel�fono: ");
                try {
                    telefono = teclado.readLine();
                } catch (IOException ex) {
                    System.out.println("\tError: fallo en la lectura");
                }

                // COMPROBACI�N DE LA CADENA DE EMAIL
                // expresi�n:   [\\+]?              0 o 1 vez -->  '+'
                //              \\d{9,14}+          entre 9 y 14 d�gitos
                //              $                   fin de la l�nea
                String regex = "^[\\+]?\\d{9,14}+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(telefono);
                emailOK = matcher.matches();

                if (!emailOK) {
                    System.out.println("\tError: Formato de tel�fono incorrecto.");
                } else {
                    lecturaCorrecta = true;
                }
            } while (!lecturaCorrecta);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }

        return telefono;

    }

    public static String leerNombre(String mensaje) {
        String nombre = "";
        boolean esValido = false;

        while (!esValido) {
            // Solicita el nombre al usuario
            nombre = Leer.leerCadena(mensaje);

            // Comprueba si el nombre solo contiene letras (y espacios opcionales)
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]+")) {
                esValido = true; // El nombre es válido si solo tiene letras y espacios
            } else {
                System.out.println("Error: El nombre solo puede contener letras.");
            }
        }

        return nombre;
    }

    public static String leerEmail(String mensaje) throws IOException {

        String email = "";
        String telefono = "";

        try {
            InputStreamReader flujo = new InputStreamReader(System.in, "ISO-8859-1");
            BufferedReader teclado = new BufferedReader(flujo);
            boolean lecturaCorrecta = false;
            boolean emailOK;

            // mientras no se tenga al menos 1 letra y haya espacios en blaco, repetimos
            do {
                System.out.print("Introduce tu email: ");
                try {
                    email = teclado.readLine();
                } catch (IOException ex) {
                    System.out.println("\t\nError: fallo en la lectura");
                }

                // COMPROBACI�N DE LA CADENA DE EMAIL
                // expresi�n:   \\w+                letras y n�mero 1 o m�s veces
                //              ([\\.-]?\\w+)*      0 o m�s veces -->  punto y una o m�s letras y n�meros
                //              @                   una arroba
                //              \\w+                letras y n�mero 1 o m�s veces
                //              ([\\.-]?\\w+)*      0 o m�s veces -->  punto y una o m�s letras y n�meros          
                //              (\\.\\w{2,3})+      1 o m�s veces -->  punto seguido de 2 o 3 letras
                //              $                   fin de la l�nea
                String regex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                emailOK = matcher.matches();

                if (!emailOK) {
                    System.out.println("\tError: Formato de email incorrecto.");
                } else {
                    lecturaCorrecta = true;
                }
            } while (!lecturaCorrecta);
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex);
        }

        return email;

    }

    public static String leerCadena(String mensaje) {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String cadena = null;
        try {
            System.out.print(mensaje);
            cadena = teclado.readLine();

        } catch (IOException ex) {
            System.out.println("Error: fallo en la lectura" + ex.getMessage());
        }

        return cadena;

    }

    //  ------------------INT-------------------//
    public static int leerEntero(String mensaje) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);

        int entero = 0;
        String auxiliar;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensaje);
                auxiliar = teclado.readLine();
                entero = Integer.parseInt(auxiliar);

                if (entero < 0) {
                    System.out.println("Error: Debes ingresar un valor correcto.");
                } else {
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes ingresar un valor correcto.");
            } catch (IOException e) {
                System.out.println("Error: Debes ingresar un valor correcto.");
            }
        }

        return entero;
    }

    //  ------------------DECIMAL-------------------//
    public static double leerDecimal(String mensaje) throws IOException {

        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);

        String auxiliar;
        double decimal;

        System.out.print(mensaje);
        auxiliar = teclado.readLine();
        decimal = Float.parseFloat(auxiliar);

        return decimal;
    }

    private static int limpiarPantalla() {
        int NUM_LINEAS = 20;
        for (int i = 0; i < NUM_LINEAS; i++) {
            System.out.println("");
        }
        return 0;
    }

    public static int leerEnteroXeY(String mensaje, int min, int max) throws IOException {
        InputStreamReader flujo = new InputStreamReader(System.in);
        BufferedReader teclado = new BufferedReader(flujo);
        String papelEnSucio;
        int entero = 0;
        boolean correcto = false;

        do {

            try {
                System.out.print(mensaje);
                papelEnSucio = teclado.readLine();
                entero = Integer.parseInt(papelEnSucio);

                if (entero >= min && entero <= max) {
                    correcto = true;

                } else {

                    System.out.println("\nERROR: El numero debe de estar entre el valor establecido..");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nERROR: En el metodo, el formato no es el correcto: ");
            }
        } while (!correcto);

        return entero;

    }

    public static char leerLetra(String mensaje) throws IOException {
        char caracter;

        System.out.print(mensaje);
        caracter = (char) System.in.read();
        System.in.read();

        while (!Character.isLetter(caracter)) {
            System.out.println("Error: Debe ingresar una letra v�lida.");
            System.out.print(mensaje);
            caracter = (char) System.in.read();
            System.in.read();
        }
        return 0;

    }

    public static String leerCorreo(String mensaje) throws IOException {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-1"));
        String correo = " ";
        boolean lecturaCorrecta = false;
        boolean emailOK;
        // mientras no se tenga al menos 1 letra y haya espacios en blaco, repetimos
        do {
            System.out.print(mensaje);
            try {
                correo = teclado.readLine();
            } catch (IOException ex) {
                System.out.println("\tError: fallo en la lectura");
            }
            String regex = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(correo);
            emailOK = matcher.matches();

            if (!emailOK) {
                System.out.println("\tError: Formato de email incorrecto.");
            } else {
                lecturaCorrecta = true;
            }
        } while (!lecturaCorrecta);

        return correo;
    }

    public static void transparenciaBoton(JButton boton) {
        boton.setOpaque(false);
        boton.setContentAreaFilled(false);
        boton.setBorderPainted(false);
    }

}

package com.mycompany.proyectorojo;

import Usos.AutenticadorBDO;
import Ventanas.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class ProyectoRojo {

    public static void main(String[] args) {
        // Crear el administrador si no existe
        AutenticadorBDO.crearAdministradorSiNoExiste();

        // Abre el JFrame de Login
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectorojo;

import Ventanas.Login;
import Ventanas.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author USUARIO
 */
public class ProyectoRojo {

    public static void main(String[] args) {
        // Configuración de JPA
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb");
    EntityManager em = emf.createEntityManager();

    // Crear usuarios manualmente
    Usuario u1 = new Usuario("juan", "1234");
    Usuario u2 = new Usuario("ana", "1234");
    Usuario u3 = new Usuario("manuel", "1234");

    try {
        // Iniciar la transacción
        em.getTransaction().begin();

        // Persistir los usuarios
        em.persist(u1);
        em.persist(u2);
        em.persist(u3);

        // Confirmar la transacción
        em.getTransaction().commit();
        System.out.println("Usuarios guardados correctamente.");
    } catch (Exception e) {
        // Si ocurre un error, revertir la transacción
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        System.err.println("Error al guardar los usuarios: " + e.getMessage());
    } finally {
        // Cerrar el EntityManager
        em.close();
        emf.close();
    }
}
}

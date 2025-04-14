/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usos;

import javax.persistence.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author david
 */
public class AutenticadorBDO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("loginPU");

    public boolean login(String username, String password) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, username);
        em.close();
        return user != null && user.getPassword().equals(password);
    }

    public void registerUser(String username, String password) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(new User(username, password));
            tx.commit();
        } finally {
            em.close();
        }
    }

    public boolean userExists(String username) {
    EntityManager em = emf.createEntityManager();
    User user = em.find(User.class, username);
    em.close();
    return user != null;
    }
}

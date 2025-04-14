package Usos;

import javax.persistence.*;

public class AutenticadorBDO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("loginPU");

    public static User validarUsuario(String nombre, String contrasena) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.username = :nombre AND u.password = :contraseña", User.class);
            query.setParameter("nombre", nombre);
            query.setParameter("contraseña", contrasena);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static void insertarUsuario(User usuario) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(usuario);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public static boolean existeUsuario(String nombre) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.username = :nombre", Long.class);
            query.setParameter("nombre", nombre);
            Long count = query.getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
}

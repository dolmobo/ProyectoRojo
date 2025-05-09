package Usos;

import java.util.List;
import javax.persistence.*;

public class AutenticadorBDO {

    /*
    
    La librería de la base de datos de objetos, se usará para guardar la
    información de los diferentes usuarios que puedan iniciar sesión dentro de
    la aplicación. Datos como nombre, contraseña y su estado.
    
    
     */
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

    /*
  Este método sirve para crear dentro de la BDO un nuevo usuario
    insertando sus datos, utilizando también la funcionalidad de "persist".
     */
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

    /*
  Este método sirve para comprobar si dentro de la BDO ya existe ese usuario
    indicado
     */

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

    /*
  Este método sirve para eliminar dentro de la BDO un usuario
    eliminando sus datos.
     */
    public static boolean eliminarUsuario(String nombreUsuario) {
        // Crea un EntityManager para conectarse a la base de datos
        EntityManager em = emf.createEntityManager();

        // Obtiene la transacción
        EntityTransaction tx = em.getTransaction();

        try {
            // Inicia la transacción
            tx.begin();

            // Busca el usuario por su nombre de usuario (clave primaria)
            User usuario = em.find(User.class, nombreUsuario);

            // Verifica si el usuario existe
            if (usuario != null) {
                // Si existe, lo elimina
                em.remove(usuario);
                tx.commit(); // Confirma la transacción
                return true;
            } else {
                // Si no existe, revierte la transacción
                tx.rollback();
                return false;
            }
        } catch (Exception e) {
            // Si hay un error, revierte la transacción si aún está activa
            if (tx.isActive()) {
                tx.rollback();
            }

            // Imprime el error en consola
            System.err.println("Error al eliminar usuario: " + e.getMessage());
            return false;
        } finally {
            // Cierra el EntityManager
            em.close();
        }
    }

    /*
  Este método sirve para obtener todos los usuarios dentro de la BDO.
     */
    public static List<User> obtenerTodosLosUsuariosLogIn() {
        EntityManager em = emf.createEntityManager();

        try {
            // Consulta que devuelve todos los usuarios
            TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    /*
  Este método sirve para crear un usuario "Administrador" en caso de que antes 
    no existiera uno.
     */
    public static void crearAdministradorSiNoExiste() {
        String usuarioAdmin = "admin";
        String contrasenaAdmin = "admin123";

        // Verificar si el usuario administrador ya existe
        if (!existeUsuario(usuarioAdmin)) {
            // Crear el nuevo usuario administrador
            User admin = new User(usuarioAdmin, contrasenaAdmin);
            admin.setRol("admin"); // Asignar el rol de administrador

            // Insertar el administrador en la base de datos
            insertarUsuario(admin);
            System.out.println("Administrador creado con éxito.");
        } else {
            System.out.println("El administrador ya existe.");
        }
    }

}

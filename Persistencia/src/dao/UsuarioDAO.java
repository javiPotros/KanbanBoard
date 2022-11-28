package dao;

import interfaces.baseDAO;
import entidades.Usuario;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class UsuarioDAO extends baseDAO<Usuario> {

    @Override
    public void agregar(Usuario usuario) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void actualizar(Usuario usuario) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Usuario usuarioExistente = entityManager.find(Usuario.class, usuario.getId());
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setRol(usuario.getRol());
            usuarioExistente.setContrasenha(usuario.getContrasenha());
            entityManager.persist(usuarioExistente);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new DAOException();
        }
    }

    @Override
    public void eliminar(long id) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            throw new DAOException();
        }
    }

    @Override
    public Usuario consultar(long id) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            Usuario usuario = entityManager.find(Usuario.class, id);
            return usuario;
        } catch (PersistenceException e) {
            throw new DAOException();
        }
    }

    public Usuario consultarPorCorreo(String correo) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.correo =:correo",
                    Usuario.class);
            query.setParameter("correo", correo);
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (PersistenceException e) {
            throw new DAOException();
        }
    }

    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            String select
                    = "SELECT u FROM Usuario u WHERE u.correo =:correo AND u.contrasenha =:contrasenha";
            Query query = entityManager.createQuery(select, Usuario.class);
            query.setParameter("correo", correo);
            query.setParameter("contrasenha", contrasenha);
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (PersistenceException e) {
            throw new DAOException();
        }
    }

    @Override
    public List<Usuario> consultarTodos() throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
            @SuppressWarnings("unchecked")
            List<Usuario> listaUsuario = query.getResultList();
            for (Usuario usuario : listaUsuario) {
                System.out.println(usuario);
            }
            return listaUsuario;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}

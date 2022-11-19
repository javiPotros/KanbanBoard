package dao;

import entidades.Comentario;
import excepciones.DAOException;
import interfaces.baseDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class ComentarioDAO extends baseDAO<Comentario> {

    @Override
    public void agregar(Comentario comentario) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(comentario);
            entityManager.getTransaction().commit();
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Comentario entidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(long idEntidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comentario consultar(long idEntidad) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Comentario> consultarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

package interfaces;

import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public abstract class baseDAO<T> {

    protected EntityManager getEntityManager() throws PersistenceException {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("kanbanJPA");
        EntityManager entityManager = managerFactory.createEntityManager();
        return entityManager;
    }

    public abstract void agregar(T entidad) throws DAOException;

    public abstract void actualizar(T entidad) throws DAOException;

    public abstract void eliminar(long idEntidad) throws DAOException;

    public abstract T consultar(long idEntidad) throws DAOException;

    public abstract List<T> consultarTodos() throws DAOException;
}

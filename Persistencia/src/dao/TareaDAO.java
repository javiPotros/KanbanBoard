package dao;

import interfaces.baseDAO;
import entidades.Tarea;
import excepciones.DAOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

public class TareaDAO extends baseDAO<Tarea> {

    @Override
    public void agregar(Tarea tarea) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tarea);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void actualizar(Tarea tarea) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tarea tareaExistente = entityManager.find(Tarea.class, tarea.getId());
            tareaExistente.setTitulo(tarea.getTitulo());
            tareaExistente.setDescripcion(tarea.getDescripcion());
            tareaExistente.setFechaLim(tarea.getFechaLim());
            tareaExistente.setEstado(tarea.getEstado());
            tareaExistente.setUsuario(tarea.getUsuario());
            entityManager.persist(tareaExistente);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    @Override
    public void eliminar(long id) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tarea tarea = entityManager.find(Tarea.class, id);
            entityManager.remove(tarea);
            entityManager.getTransaction().commit();
        } catch (PersistenceException ex) {
            throw new DAOException();
        }

    }

    @Override
    public Tarea consultar(long id) throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            Tarea tarea = entityManager.find(Tarea.class, id);
            entityManager.refresh(tarea);
            return tarea;
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    @Override
    public List<Tarea> consultarTodos() throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t", Tarea.class);
            @SuppressWarnings("unchecked")
            List<Tarea> listaTareas = query.getResultList();
            return listaTareas;
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    public List<Tarea> consultarPorHacer() throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 0",
                    Tarea.class);
            @SuppressWarnings("unchecked")
            List<Tarea> listaTareas = query.getResultList();
            return listaTareas;
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    public List<Tarea> consultarEnProgreso() throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 1",
                    Tarea.class);
            @SuppressWarnings("unchecked")
            List<Tarea> listaTareas = query.getResultList();
            return listaTareas;
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

    public List<Tarea> consultarRealizado() throws DAOException {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query
                    = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 2", Tarea.class);
            @SuppressWarnings("unchecked")
            List<Tarea> listaTareas = query.getResultList();
            return listaTareas;
        } catch (PersistenceException ex) {
            throw new DAOException();
        }
    }

}

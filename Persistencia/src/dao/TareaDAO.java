package dao;

import interfaces.baseDAO;
import entidades.Tarea;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TareaDAO extends baseDAO<Tarea> {

    @Override
    public Tarea agregar(Tarea tarea) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(tarea);
            entityManager.getTransaction().commit();
            return tarea;
        } catch (HeadlessException | PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Tarea actualizar(Tarea tarea) {
        try {
            if (tarea.getId() == null || tarea == null) {
                throw new IllegalArgumentException("La tarea no es valida");
            }
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tarea tareaVieja = entityManager.find(Tarea.class, tarea.getId());
            if (tareaVieja == null) {
                throw new Exception("La tarea no existe");
            }

            tareaVieja.setTitulo(tarea.getTitulo());
            tareaVieja.setDescripcion(tarea.getDescripcion());
            tareaVieja.setFechaLim(tarea.getFechaLim());
            tareaVieja.setUsuario(tarea.getUsuario());
            tareaVieja.setEstado(tarea.getEstado());

            entityManager.persist(tareaVieja);
            entityManager.getTransaction().commit();
            return tarea;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void eliminar(long id) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Tarea tarea = entityManager.find(Tarea.class, id);
            if (tarea != null) {
                entityManager.remove(tarea);
            }
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (HeadlessException | PersistenceException e) {
            JOptionPane.showMessageDialog(null, "Error: Esta tarea no se pudo eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public Tarea consultar(long id) {
        try {
            EntityManager entityManager = this.getEntityManager();
            Tarea tarea = entityManager.find(Tarea.class, id);
            entityManager.refresh(tarea);
            return tarea;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Tarea> consultarTodos() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t", Tarea.class);
            List<Tarea> listaTarea = query.getResultList();
            return listaTarea;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Tarea> consultarPorHacer() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 0", Tarea.class);
            List<Tarea> listaTarea = query.getResultList();
            return listaTarea;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Tarea> consultarEnProgreso() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 1", Tarea.class);
            List<Tarea> listaTarea = query.getResultList();
            return listaTarea;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<Tarea> consultarRealizado() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t WHERE t.estado = 2", Tarea.class);
            List<Tarea> listaTarea = query.getResultList();
            return listaTarea;
        } catch (PersistenceException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}

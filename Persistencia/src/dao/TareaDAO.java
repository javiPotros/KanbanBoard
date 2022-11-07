package dao;

import interfaces.baseDAO;
import entidades.Tarea;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TareaDAO extends baseDAO<Tarea>{

	@Override
	public void agregar(Tarea usuario) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(usuario);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (HeadlessException | PersistenceException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void actualizar(Tarea usuario) {
		try {
			if (usuario.getId() == null || usuario == null) {
				throw new IllegalArgumentException("La tarea no es valida");
			}
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Tarea tareaVieja = entityManager.find(Tarea.class, usuario.getId());
			if (tareaVieja == null) {
				throw new Exception("La tarea no existe");
			}
			
			tareaVieja.setTitulo(usuario.getTitulo());
			tareaVieja.setDescripcion(usuario.getDescripcion());
			tareaVieja.setFechaLim(usuario.getFechaLim());
			tareaVieja.setUsuario(usuario.getUsuario());
			
			entityManager.persist(tareaVieja);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.err.println(e.getMessage());
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
			List<Tarea> listaTarea=  query.getResultList();
			return listaTarea;
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}

package dao;

import entidades.Tarea;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TareaDAO extends baseDAO<Tarea>{

	@Override
	public void agregar(Tarea entidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(entidad);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void actualizar(Tarea entidad) {
		try {
			if (entidad.getId() == null || entidad == null) {
				throw new IllegalArgumentException("La tarea no es valida");
			}
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Tarea tareaVieja = entityManager.find(Tarea.class, entidad.getId());
			if (tareaVieja == null) {
				throw new Exception("La tarea no existe");
			}
			
			tareaVieja.setTitulo(entidad.getTitulo());
			tareaVieja.setDescripcion(entidad.getDescripcion());
			tareaVieja.setFechaLim(entidad.getFechaLim());
			tareaVieja.setUsuario(entidad.getUsuario());
			
			entityManager.persist(tareaVieja);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void eliminar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Tarea tarea = entityManager.find(Tarea.class, idEntidad);
			if (tarea != null) {
				entityManager.remove(tarea);
			}
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Esta tarea no se pudo eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Tarea consultar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			Tarea tarea = entityManager.find(Tarea.class, idEntidad);
			return tarea;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Tarea> consultarTodo() {
		try {
			EntityManager entityManager = this.getEntityManager();
			TypedQuery query = entityManager.createQuery("SELECT t FROM Tarea t", Tarea.class);
			List<Tarea> listaTarea=  query.getResultList();
			return listaTarea;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}

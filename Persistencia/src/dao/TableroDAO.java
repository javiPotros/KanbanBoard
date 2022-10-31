package dao;

import entidades.Tablero;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TableroDAO extends baseDAO<Tablero>{

	@Override
	public void agregar(Tablero entidad) {
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
	public void actualizar(Tablero entidad) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Tablero tablero = entityManager.find(Tablero.class, idEntidad);
			if (tablero != null) {
				entityManager.remove(tablero);
			}
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Este tablero no se pudo eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Tablero consultar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			Tablero tablero = entityManager.find(Tablero.class, idEntidad);
			return tablero;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Tablero> consultarTodo() {
		try {
			EntityManager entityManager = this.getEntityManager();
			TypedQuery query = entityManager.createQuery("SELECT t FROM Tablero t", Tablero.class);
			List<Tablero> listaTablero=  query.getResultList();
			return listaTablero;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}

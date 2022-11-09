package dao;

import interfaces.baseDAO;
import entidades.Tablero;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class TableroDAO extends baseDAO<Tablero>{

	@Override
	public Tablero agregar(Tablero tablero) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(tablero);
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Información",
					JOptionPane.INFORMATION_MESSAGE);
                        return tablero;
		} catch (HeadlessException | PersistenceException e) {
			System.err.println(e.getMessage());
                        return null;
		}
	}

	@Override
	public Tablero actualizar(Tablero tablero) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(long id) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Tablero tablero = entityManager.find(Tablero.class, id);
			if (tablero != null) {
				entityManager.remove(tablero);
			}
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (HeadlessException | PersistenceException e) {
			JOptionPane.showMessageDialog(null, "Error: Este tablero no se pudo eliminar", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Tablero consultar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			Tablero tablero = entityManager.find(Tablero.class, idEntidad);
			return tablero;
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Tablero> consultarTodos() {
		try {
			EntityManager entityManager = this.getEntityManager();
			TypedQuery query = entityManager.createQuery("SELECT t FROM Tablero t", Tablero.class);
			List<Tablero> listaTablero=  query.getResultList();
			return listaTablero;
		} catch (PersistenceException e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}

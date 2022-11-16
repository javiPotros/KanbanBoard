package dao;

import entidades.Comentario;
import interfaces.baseDAO;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

public class ComentarioDAO extends baseDAO<Comentario>{

	
	public void agregar2Comentario (Comentario entidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(entidad);
			entityManager.getTransaction().commit();
		} catch (HeadlessException | PersistenceException e) {
			System.err.println(e.getMessage());
		}
	}

	@Override
	public Comentario actualizar(Comentario entidad) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(long idEntidad) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Comentario consultar(long idEntidad) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Comentario> consultarTodos() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Comentario agregar(Comentario entidad) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}

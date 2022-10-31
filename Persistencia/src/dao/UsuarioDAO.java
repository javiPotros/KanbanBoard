package dao;

import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class UsuarioDAO extends baseDAO<Usuario>{

	@Override
	public void agregar(Usuario entidad) {
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
	public void actualizar(Usuario entidad) {
		try {
			if (entidad.getId() == null || entidad == null) {
				throw new IllegalArgumentException("El usuario no es valido");
			}
			EntityManager entityManager = this.getEntityManager();
			entityManager.getTransaction().begin();
			Usuario usuarioViejo = entityManager.find(Usuario.class, entidad.getId());
			if (usuarioViejo == null) {
				throw new Exception("El usuario no existe");
			}
			usuarioViejo.setNombre(entidad.getNombre());
			entityManager.persist(usuarioViejo);
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
			Usuario usuario = entityManager.find(Usuario.class, idEntidad);
			if (usuario != null) {
				entityManager.remove(usuario);
			}
			entityManager.getTransaction().commit();
			JOptionPane.showMessageDialog(null, "Se ha elimino correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error: Este usuario esta en una tarea", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public Usuario consultar(long idEntidad) {
		try {
			EntityManager entityManager = this.getEntityManager();
			Usuario usuario = entityManager.find(Usuario.class, idEntidad);
			return usuario;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}

	@Override
	public List<Usuario> consultarTodo() {
		try {
			EntityManager entityManager = this.getEntityManager();
			TypedQuery query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
			List<Usuario> listaUsuario=  query.getResultList();
			return listaUsuario;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
	
}

package dao;

import interfaces.baseDAO;
import entidades.Usuario;
import java.awt.HeadlessException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class UsuarioDAO extends baseDAO<Usuario> {

    @Override
    public void agregar(Usuario usuario) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha guardado correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            if (usuario.getId() == null || usuario == null) {
                throw new IllegalArgumentException("El usuario no es valido");
            }
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            Usuario usuarioViejo = entityManager.find(Usuario.class, usuario.getId());
            if (usuarioViejo == null) {
                throw new Exception("El usuario no existe");
            }
            usuarioViejo.setNombre(usuario.getNombre());
            entityManager.persist(usuarioViejo);
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
            Usuario usuario = entityManager.find(Usuario.class, id);
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
    public Usuario consultar(long id) {
        try {
            EntityManager entityManager = this.getEntityManager();
            Usuario usuario = entityManager.find(Usuario.class, id);
            return usuario;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Usuario> consultarTodos() {
        try {
            EntityManager entityManager = this.getEntityManager();
            TypedQuery query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
            List<Usuario> listaUsuario = query.getResultList();
            for (Usuario usuario : listaUsuario) {
                System.out.println(usuario);
            }
            return listaUsuario;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}

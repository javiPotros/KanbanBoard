package dao;

import interfaces.baseDAO;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class UsuarioDAO extends baseDAO<Usuario> {

    @Override
    public Usuario agregar(Usuario usuario) {
        try {
            EntityManager entityManager = this.getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            return usuario;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public Usuario actualizar(Usuario usuario) {
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
	   usuarioViejo.setRol(usuario.getRol());
	   usuarioViejo.setCorreo(usuario.getCorreo());
	   usuarioViejo.setContrasenha(usuario.getContrasenha());
            entityManager.persist(usuarioViejo);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente", "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            return usuario;
        } catch (Exception e) {
            //REVISAR
            System.err.println(e.getMessage());
            return null;
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

    public Usuario consultarPorCorreo(String correo) {
        try {
            EntityManager entityManager = this.getEntityManager();
            Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.correo =:correo", Usuario.class);
            query.setParameter("correo", correo);
            Usuario usuario = (Usuario) query.getSingleResult();
            return usuario;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }       
    }
    
    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha) {
        try {
            EntityManager entityManager = this.getEntityManager();
            Query query = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.correo =:correo AND u.contrasenha =:contrasenha", Usuario.class);
            query.setParameter("correo", correo);
            query.setParameter("contrasenha", contrasenha);
            Usuario usuario = (Usuario) query.getSingleResult();
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

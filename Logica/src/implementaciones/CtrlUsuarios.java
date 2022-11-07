package implementaciones;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Usuario;
import java.util.List;

public class CtrlUsuarios {

    //DAOFactory daoFactory;
    UsuarioDAO usuarioDAO;

    public CtrlUsuarios() {
        //this.daoFactory = daoFactory;
        usuarioDAO = new UsuarioDAO();
    }

    public void agregar(Usuario usuario) {
        usuarioDAO.agregar(usuario);
    }

    public List<Usuario> consultarTodos() {
        return usuarioDAO.consultarTodos();
    }

}

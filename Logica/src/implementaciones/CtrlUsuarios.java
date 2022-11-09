package implementaciones;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Usuario;
import java.util.List;

public class CtrlUsuarios {

    UsuarioDAO usuarioDAO;

    public CtrlUsuarios() {
        usuarioDAO = DAOFactory.crearUsuarioDAO();
    }

    public Usuario agregar(Usuario usuario) throws Exception {
            validarCampos(usuario);
            return usuarioDAO.agregar(usuario);
    }

    public List<Usuario> consultarTodos() {
        return usuarioDAO.consultarTodos();
    }

    private void validarCampos(Usuario usuario) throws Exception {
        validarNombre(usuario.getNombre());
        validarRol(usuario.getRol());
        validarCorreo(usuario.getCorreo());
        validarContrasenha(usuario.getContrasenha());
    }

    private void validarNombre(String nombre) throws Exception {
        if (nombre.isBlank()) {
            throw new Exception("Introduzca un nombre");
        } else if (nombre.length() > 100) {
            throw new Exception("El nombre debe tener máximo 100 caracteres");
        }
    }

    private void validarRol(String rol) throws Exception {
        if (rol.equalsIgnoreCase("-Seleccionar-")) {
            throw new Exception("Seleccione un rol");
        }
    }

    private void validarCorreo(String correo) throws Exception {
        if (correo.isBlank()) {
            throw new Exception("Introduzca un nombre");
        } else if (correo.length() > 100) {
            throw new Exception("El nombre debe tener máximo 100 caracteres");
        }
    }

    private void validarContrasenha(String contrasenha) throws Exception {
        if (contrasenha.isBlank()) {
            throw new Exception("Introduzca un nombre");
        } else if (contrasenha.length() > 100) {
            throw new Exception("El nombre debe tener máximo 100 caracteres");
        }
    }

}

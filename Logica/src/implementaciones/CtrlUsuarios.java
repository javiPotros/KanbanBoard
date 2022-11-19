package implementaciones;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Usuario;
import excepciones.DAOException;
import java.util.List;
import java.util.regex.Pattern;

public class CtrlUsuarios {

    UsuarioDAO usuarioDAO;

    public CtrlUsuarios() {
        usuarioDAO = DAOFactory.crearUsuarioDAO();
    }

    public void agregar(Usuario usuario) throws IllegalArgumentException, DAOException {
        validarCampos(usuario);
        usuarioDAO.agregar(usuario);
    }

    public void actualizar(Usuario usuario) throws IllegalArgumentException, DAOException {
        validarCampos(usuario);
        usuarioDAO.actualizar(usuario);
    }

    public void eliminar(Long id) throws NullPointerException, DAOException {
        if (id != null) {
            usuarioDAO.eliminar(id);
        } else {
            throw new NullPointerException();
        }
    }

    public Usuario consultar(Long id) throws NullPointerException, DAOException {
        if (id != null) {
            return usuarioDAO.consultar(id);
        } else {
            throw new NullPointerException();
        }
    }

    public Usuario consultarPorCorreo(String correo) throws NullPointerException, DAOException {
        if (correo != null) {
            return usuarioDAO.consultarPorCorreo(correo);
        } else {
            throw new NullPointerException();
        }
    }

    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha)
            throws NullPointerException, DAOException {
        if (correo != null && contrasenha != null) {
            return usuarioDAO.consultarPorCorreoYContrasenha(correo, contrasenha);
        } else {
            throw new NullPointerException();
        }
    }

    public List<Usuario> consultarTodos() throws DAOException{
        return usuarioDAO.consultarTodos();
    }

    private void validarCampos(Usuario usuario) throws IllegalArgumentException {
        validarNombre(usuario.getNombre());
        validarRol(usuario.getRol());
        validarCorreo(usuario.getCorreo());
        validarContrasenha(usuario.getContrasenha());
    }

    private void validarNombre(String nombre) throws IllegalArgumentException {
        if (nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Introduzca un nombre");
        } else if (nombre.length() > 100) {
            throw new IllegalArgumentException("El nombre debe tener máximo 100 caracteres");
        }
    }

    private void validarRol(String rol) throws IllegalArgumentException {
        if (rol.equalsIgnoreCase("-Seleccionar-")) {
            throw new IllegalArgumentException("Seleccione un rol");
        }
    }

    private void validarCorreo(String correo) throws IllegalArgumentException {
        Pattern patron = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        boolean emailValido = patron.matcher(correo).matches();
        Usuario usuario = consultarPorCorreo(correo);

        if (correo.trim().isEmpty()) {
            throw new IllegalArgumentException("Introduzca un correo");
        } else if (correo.length() > 100) {
            throw new IllegalArgumentException("El correo debe tener máximo 100 caracteres");
        } else if (!emailValido) {
            throw new IllegalArgumentException("Introduzca un correo válido");
        } else if (usuario != null) {
            throw new IllegalArgumentException("El correo introducido ya esta asociado a una cuenta");
        }
    }

    private void validarContrasenha(String contrasenha) throws IllegalArgumentException {
        if (contrasenha.trim().isEmpty()) {
            throw new IllegalArgumentException("Introduzca una contraseña");
        } else if (contrasenha.length() > 100) {
            throw new IllegalArgumentException("La contraseña debe tener máximo 100 caracteres");
        }
    }

}

package implementaciones;

import dao.DAOFactory;
import dao.UsuarioDAO;
import entidades.Usuario;
import java.util.List;
import java.util.regex.Pattern;

public class CtrlUsuarios {

    UsuarioDAO usuarioDAO;

    public CtrlUsuarios() {
        usuarioDAO = DAOFactory.crearUsuarioDAO();
    }

    public Usuario agregar(Usuario usuario) throws Exception {
        validarCampos(usuario);
        return usuarioDAO.agregar(usuario);
    }

    public Usuario consultar(Long id) {
        return usuarioDAO.consultar(id);
    }

    public Usuario consultarPorCorreo(String correo) {
        return usuarioDAO.consultarPorCorreo(correo);
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
        if (nombre.trim().isEmpty()) {
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
        Pattern patron = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        boolean emailValido = patron.matcher(correo).matches();
        Usuario usuario = consultarPorCorreo(correo);

        if (correo.trim().isEmpty()) {
            throw new Exception("Introduzca un correo");
        } else if (correo.length() > 100) {
            throw new Exception("El correo debe tener máximo 100 caracteres");
        } else if (!emailValido) {
            throw new Exception("Introduzca un correo válido");
        } else if (usuario != null) {
            throw new Exception("El correo introducido ya esta asociado a una cuenta");
        }
    }
    

    private void validarContrasenha(String contrasenha) throws Exception {
        if (contrasenha.trim().isEmpty()) {
            throw new Exception("Introduzca una contraseña");
        } else if (contrasenha.length() > 100) {
            throw new Exception("La contraseña debe tener máximo 100 caracteres");
        }
    }

}

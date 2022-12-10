package implementaciones;

import entidades.Comentario;
import entidades.Tablero;
import entidades.Tarea;
import entidades.Usuario;
import interfaces.INegocios;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Negocios implements INegocios {

    CtrlUsuarios ctrlUsuarios;
    CtrlTareas ctrlTareas;
    CtrlComentario ctrlComentario;
    CtrlTableros ctrlTableros;

    public Negocios() {
        ctrlUsuarios = new CtrlUsuarios();
        ctrlTareas = new CtrlTareas();
        ctrlComentario = new CtrlComentario();
        ctrlTableros = new CtrlTableros();
    }

    @Override
    public Usuario agregarUsuario(Usuario usuario) throws Exception {
        return ctrlUsuarios.agregar(usuario);
    }

    @Override
    public Usuario consultarUsuario(Long id) {
        return ctrlUsuarios.consultar(id);
    }

    @Override
    public Usuario consultarUsuarioCorreo(String correo) {
        return ctrlUsuarios.consultarPorCorreo(correo);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return ctrlUsuarios.consultarTodos();
    }
    
    @Override
    public List<String> consultarRoles() {
        return ctrlUsuarios.consultarRoles();
    }

    @Override
    public void agregarTarea(Tarea tarea) throws Exception {
        ctrlTareas.agregar(tarea);
    }

    @Override
    public void actualizarTarea(Tarea tarea) throws Exception {
        ctrlTareas.actualizar(tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        ctrlTareas.eliminar(id);
    }

    @Override
    public Tarea consultarTarea(Long id) {
        return ctrlTareas.consultar(id);
    }

    @Override
    public List<Tarea> consultarTareasPorHacer() {
        return ctrlTareas.consultarPorHacer();
    }

    @Override
    public List<Tarea> consultarTareasEnProgreso() {
        return ctrlTareas.consultarEnProgeso();
    }

    @Override
    public List<Tarea> consultarTareasRealizado() {
        return ctrlTareas.consultarRealizado();
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws Exception {
        ctrlUsuarios.actualizar(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        ctrlUsuarios.eliminar(id);
    }

    @Override
    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha) throws Exception {
        return ctrlUsuarios.consultarPorCorreoYContrasenha(correo, contrasenha);
    }

    @Override
    public void agregarComentario(Comentario comentario) {
        try {
            ctrlComentario.agregar(comentario);
        } catch (Exception ex) {
            Logger.getLogger(Negocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void agregarTablero(Tablero tablero) {
        try {
            ctrlTableros.agregar(tablero);
        } catch (Exception ex) {
            Logger.getLogger(Negocios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Tablero> consultarTableros() {
        return ctrlTableros.consultarTodos();
    }

    @Override
    public void cambiarNombre(Tablero tablero) {
        ctrlTableros.cambiarNombre(tablero);
    }
}

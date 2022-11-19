package implementaciones;

import entidades.Comentario;
import entidades.Tarea;
import entidades.Usuario;
import excepciones.DAOException;
import interfaces.INegocios;
import java.util.List;

public class Negocios implements INegocios {

    CtrlUsuarios ctrlUsuarios;
    CtrlTareas ctrlTareas;
    CtrlComentario ctrlComentario;
    //CtrlTableros ctrlTableros;

    public Negocios() {
        ctrlUsuarios = new CtrlUsuarios();
        ctrlTareas = new CtrlTareas();
        ctrlComentario = new CtrlComentario();
        //ctrlTableros = new CtrlTableros();
    }

    @Override
    public void agregarUsuario(Usuario usuario) throws IllegalArgumentException, DAOException {
        ctrlUsuarios.agregar(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) throws IllegalArgumentException, DAOException {
        ctrlUsuarios.actualizar(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) throws NullPointerException, DAOException {
        ctrlUsuarios.eliminar(id);
    }

    @Override
    public Usuario consultarUsuario(Long id) throws NullPointerException, DAOException {
        return ctrlUsuarios.consultar(id);
    }

    @Override
    public Usuario consultarUsuarioPorCorreo(String correo) throws NullPointerException, DAOException {
        return ctrlUsuarios.consultarPorCorreo(correo);
    }

    @Override
    public Usuario consultarUsuarioPorCorreoYContrasenha(String correo, String contrasenha) 
            throws NullPointerException, DAOException {
        return ctrlUsuarios.consultarPorCorreoYContrasenha(correo, contrasenha);
    }

    @Override
    public List<Usuario> consultarUsuarios() throws DAOException {
        return ctrlUsuarios.consultarTodos();
    }

    @Override
    public void agregarTarea(Tarea tarea) throws IllegalArgumentException, DAOException {
        ctrlTareas.agregar(tarea);
    }

    @Override
    public void actualizarTarea(Tarea tarea) throws IllegalArgumentException, DAOException {
        ctrlTareas.actualizar(tarea);
    }

    @Override
    public void eliminarTarea(Long id) throws NullPointerException, DAOException {
        ctrlTareas.eliminar(id);
    }

    @Override
    public Tarea consultarTarea(Long id) throws NullPointerException, DAOException {
        return ctrlTareas.consultar(id);
    }

    @Override
    public List<Tarea> consultarTareasPorHacer() throws DAOException {
        return ctrlTareas.consultarPorHacer();
    }

    @Override
    public List<Tarea> consultarTareasEnProgreso() throws DAOException {
        return ctrlTareas.consultarEnProgeso();
    }

    @Override
    public List<Tarea> consultarTareasRealizado() throws DAOException {
        return ctrlTareas.consultarRealizado();
    }

    @Override
    public void agregarComentario(Comentario comentario) throws DAOException {
        ctrlComentario.agregar(comentario);
    }

}

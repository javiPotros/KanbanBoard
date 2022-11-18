package interfaces;

import entidades.*;
import java.util.List;

public interface INegocios {

    public Usuario agregarUsuario(Usuario usuario) throws Exception;

    public void actualizarUsuario(Usuario usuario) throws Exception;

    public void eliminarUsuario(Long id);

    public Usuario consultarUsuario(Long id);

    public Usuario consultarUsuarioCorreo(String correo);

    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha) throws Exception;

    public List<Usuario> consultarUsuarios();
    
    public List<String> consultarRoles();

    public void agregarTarea(Tarea tarea) throws Exception;

    public void actualizarTarea(Tarea tarea) throws Exception;

    public void eliminarTarea(Long id);

    public Tarea consultarTarea(Long id);

    public List<Tarea> consultarTareasPorHacer();

    public List<Tarea> consultarTareasEnProgreso();

    public List<Tarea> consultarTareasRealizado();

    public void agregarComentario(Comentario comentario);
}

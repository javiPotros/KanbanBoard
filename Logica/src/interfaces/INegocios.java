package interfaces;

import entidades.*;
import excepciones.DAOException;
import java.util.List;

public interface INegocios {

    public void agregarUsuario(Usuario usuario) throws IllegalArgumentException, DAOException;

    public void actualizarUsuario(Usuario usuario) throws IllegalArgumentException, DAOException;

    public void eliminarUsuario(Long id) throws NullPointerException, DAOException;

    public Usuario consultarUsuario(Long id) throws NullPointerException, DAOException;

    public Usuario consultarUsuarioPorCorreo(String correo) throws NullPointerException, DAOException;

    public Usuario consultarUsuarioPorCorreoYContrasenha(String correo, String contrasenha) 
            throws NullPointerException, DAOException;

    public List<Usuario> consultarUsuarios() throws DAOException;

    public void agregarTarea(Tarea tarea) throws IllegalArgumentException, DAOException;

    public void actualizarTarea(Tarea tarea) throws IllegalArgumentException, DAOException;

    public void eliminarTarea(Long id) throws NullPointerException, DAOException;

    public Tarea consultarTarea(Long id) throws NullPointerException, DAOException;

    public List<Tarea> consultarTareasPorHacer() throws DAOException;

    public List<Tarea> consultarTareasEnProgreso() throws DAOException;

    public List<Tarea> consultarTareasRealizado() throws DAOException;

    public void agregarComentario(Comentario comentario) throws DAOException;
}

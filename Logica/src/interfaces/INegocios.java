  package interfaces;

import entidades.*;
import java.util.List;

public interface INegocios {

    public Usuario agregarUsuario(Usuario usuario) throws Exception;
	
	public void actualizarUsuario(Usuario usuario);
	
	public void eliminarUsuario(Long id);
  
    public Usuario consultarUsuario(Long id);
    
    public Usuario consultarUsuarioCorreo(String correo);
    
    public Usuario consultarPorCorreoYContrasenha(String correo, String contrasenha);
    
    public List<Usuario> consultarUsuarios();

    public void agregarTarea(Tarea tarea) throws Exception;

    public void actualizarTarea(Tarea tarea) throws Exception;

    public void eliminarTarea(Long id);

    public Tarea consultarTarea(Long id);
    
    public List<Tarea> consultarTareasPorHacer();
}

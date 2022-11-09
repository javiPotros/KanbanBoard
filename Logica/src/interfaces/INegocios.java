  package interfaces;

import entidades.*;
import java.util.List;

public interface INegocios {

    public Usuario agregarUsuario(Usuario usuario) throws Exception;
  
    public List<Usuario> consultarUsuarios();

    public void agregarTarea(Tarea tarea) throws Exception;

    public void actualizarTarea(Tarea tarea);

    public void eliminarTarea(Long id);

    public void consultarTarea(Long id);
    
    public List<Tarea> consultarTareasPorHacer();
}

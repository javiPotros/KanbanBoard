package interfaces;

import entidades.*;
import java.util.List;

public interface INegocios {

    public void agregarUsuario(Usuario usuario);
  
    public List<Usuario> consultarUsuarios();

    public void agregarTarea(Tarea tarea);

    public void actualizarTarea(Tarea tarea);

    public void eliminarTarea(Long id);

    public void consultarTarea(Long id);
}
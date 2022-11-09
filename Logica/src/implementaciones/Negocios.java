package implementaciones;

import entidades.Tarea;
import entidades.Usuario;
import interfaces.INegocios;
import java.util.List;

public class Negocios implements INegocios {

    CtrlUsuarios ctrlUsuarios;
    CtrlTareas ctrlTareas;
    //CtrlTableros ctrlTableros;

    public Negocios() {
        ctrlUsuarios = new CtrlUsuarios();
        ctrlTareas = new CtrlTareas();
//        ctrlTableros = new CtrlTableros();
    }

    @Override
    public Usuario agregarUsuario(Usuario usuario) throws Exception {
        return ctrlUsuarios.agregar(usuario);
    }

    @Override
    public List<Usuario> consultarUsuarios() {
        return ctrlUsuarios.consultarTodos();
    }

    @Override
    public void agregarTarea(Tarea tarea) {
        ctrlTareas.agregar(tarea);
    }

    @Override
    public void actualizarTarea(Tarea tarea) {
        ctrlTareas.actualizar(tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        ctrlTareas.eliminar(id);
    }

    @Override
    public void consultarTarea(Long id) {
        ctrlTareas.consultar(id);
    }

}

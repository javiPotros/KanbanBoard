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
	public void actualizarUsuario(Usuario usuario) {
		ctrlUsuarios.actualizas(usuario);
	}

	@Override
	public void eliminarUsuario(Long id) {
            ctrlUsuarios.eliminar(id);
	}

}

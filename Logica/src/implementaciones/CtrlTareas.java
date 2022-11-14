package implementaciones;

import dao.DAOFactory;
import dao.TareaDAO;
import entidades.Tarea;
import java.util.Date;
import java.util.List;

public class CtrlTareas {

    TareaDAO tareaDAO;

    public CtrlTareas() {
        tareaDAO = DAOFactory.crearTareaDAO();
    }

    public void agregar(Tarea tarea) throws Exception {
        validarCampos(tarea);
        tareaDAO.agregar(tarea);
    }

    public void actualizar(Tarea tarea) throws Exception {
        validarCampos(tarea);
        tareaDAO.actualizar(tarea);
    }

    public void eliminar(Long id) {
        tareaDAO.eliminar(id);
    }

    public Tarea consultar(Long id) {
        return tareaDAO.consultar(id);
    }

    public List<Tarea> consultarPorHacer() {
        return tareaDAO.consultarPorHacer();
    }

    private void validarCampos(Tarea tarea) throws Exception {
        validarTitulo(tarea.getTitulo());
        validarDescripcion(tarea.getDescripcion());
        validarFecha(tarea.getFechaLim());
    }

    private void validarTitulo(String titulo) throws Exception {
        if (titulo.equalsIgnoreCase("")) {
            throw new Exception("Introduzca un título");
        } else if (titulo.length() > 100) {
            throw new Exception("El título debe tener máximo 100 caracteres");
        }
    }
    
    private void validarDescripcion(String descripcion) throws Exception {
        if (descripcion.equalsIgnoreCase("")) {
            throw new Exception("Introduzca un título");
        } else if (descripcion.length() > 300) {
            throw new Exception("La descripción debe de tener máximo 100 caracteres");
        }
    }
    
    private void validarFecha(Date fecha) throws Exception {
        if(fecha == null){
            throw new Exception("Introduzca una fecha");
        }
        else if (fecha.before(new Date())) {
            throw new Exception("La fecha debe de ser posterior a la fecha actual");
        }
    }
}

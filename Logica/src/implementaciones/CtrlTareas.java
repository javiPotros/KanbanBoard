package implementaciones;

import dao.DAOFactory;
import dao.TareaDAO;
import entidades.Tarea;
import excepciones.DAOException;
import java.util.Date;
import java.util.List;

public class CtrlTareas {

    TareaDAO tareaDAO;

    public CtrlTareas() {
        tareaDAO = DAOFactory.crearTareaDAO();
    }

    public void agregar(Tarea tarea) throws IllegalArgumentException, DAOException {
        validarCampos(tarea);
        tareaDAO.agregar(tarea);
    }

    public void actualizar(Tarea tarea) throws IllegalArgumentException, DAOException {
        validarCampos(tarea);
        tareaDAO.actualizar(tarea);
    }

    public void eliminar(Long id) throws NullPointerException, DAOException {
        if (id != null) {
            tareaDAO.eliminar(id);
        } else {
            throw new NullPointerException();
        }
    }

    public Tarea consultar(Long id) throws NullPointerException, DAOException {
        if (id != null) {
            return tareaDAO.consultar(id);
        } else {
            throw new NullPointerException();
        }
    }

    public List<Tarea> consultarPorHacer() throws DAOException {
        return tareaDAO.consultarPorHacer();
    }

    public List<Tarea> consultarEnProgeso() throws DAOException {
        return tareaDAO.consultarEnProgreso();
    }

    public List<Tarea> consultarRealizado() throws DAOException {
        return tareaDAO.consultarRealizado();
    }

    private void validarCampos(Tarea tarea) throws DAOException {
        validarTitulo(tarea.getTitulo());
        validarDescripcion(tarea.getDescripcion());
        validarFecha(tarea.getFechaLim());
    }

    private void validarTitulo(String titulo) throws IllegalArgumentException {
        if (titulo.equalsIgnoreCase("")) {
            throw new IllegalArgumentException("Introduzca un título");
        } else if (titulo.length() > 100) {
            throw new IllegalArgumentException("El título debe tener máximo 100 caracteres");
        }
    }

    private void validarDescripcion(String descripcion) throws IllegalArgumentException {
//        if (descripcion.equalsIgnoreCase("")) {
//            throw new IllegalArgumentException("Introduzca un título");
//        } 
        if (descripcion.length() > 300) {
            throw new IllegalArgumentException("La descripción debe de tener máximo 100 caracteres");
        }
    }

    private void validarFecha(Date fecha) throws IllegalArgumentException {
        if (fecha == null) {
            throw new IllegalArgumentException("Introduzca una fecha");
        } else if (fecha.before(new Date())) {
            throw new IllegalArgumentException("La fecha debe de ser posterior a la fecha actual");
        }
    }
}

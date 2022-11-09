package implementaciones;

import dao.DAOFactory;
import dao.TareaDAO;
import entidades.Tarea;
import java.util.List;

public class CtrlTareas {

    TareaDAO tareaDAO;

    public CtrlTareas() {
        tareaDAO = DAOFactory.crearTareaDAO();
    }
    
    public void agregar(Tarea tarea) {
        tareaDAO.agregar(tarea);
    }

    public void actualizar(Tarea tarea) {
        tareaDAO.actualizar(tarea);
    }

    public void eliminar(Long id) {
        tareaDAO.eliminar(id);
    }

    public void consultar(Long id) {
        tareaDAO.consultar(id);
    }
    
    public List<Tarea> consultarPorHacer() {
        return tareaDAO.consultarPorHacer();
    }
}

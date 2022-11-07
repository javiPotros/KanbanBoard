package implementaciones;

import dao.DAOFactory;
import dao.TareaDAO;
import entidades.Tarea;

public class CtrlTareas {

    DAOFactory daoFactory;
    TareaDAO tareaDAO;

    public CtrlTareas(DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
        tareaDAO = daoFactory.crearTareaDAO();
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

}

package implementaciones;

import dao.DAOFactory;
import dao.TableroDAO;
import entidades.Tablero;
import java.util.List;

public class CtrlTableros {
    
    TableroDAO tableroDAO;

    public CtrlTableros() {
        tableroDAO = DAOFactory.crearTableroDAO();
    }
    
    public void agregar(Tablero tablero) throws Exception {
        tableroDAO.agregar(tablero);
    }
    
    public List<Tablero> consultarTodos() {
        return tableroDAO.consultarTodos();
    }
}

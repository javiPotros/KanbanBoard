
import dao.TableroDAO;
import dao.TareaDAO;
import dao.UsuarioDAO;
import entidades.Tablero;
import entidades.Tarea;
import entidades.Usuario;
import java.util.GregorianCalendar;

public class pruebas {

	public static void main(String[] args) {
		UsuarioDAO uDao = new UsuarioDAO();
		TableroDAO taDao = new TableroDAO();
		TareaDAO tDao = new TareaDAO();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Usuario user = new Usuario("Rodolfo", "lider", "rodolfo@gmail.com", "1234");
		uDao.agregar(user);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Usuario user = uDao.consultar(1);
//		Usuario userNew = new Usuario();
//		userNew.setId(user.getId());
//		userNew.setNombre("Fabela");
//		uDao.actualizar(userNew);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Tablero tablero = new Tablero("FrontEnd");
//		taDao.agregar(tablero);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		GregorianCalendar fecha = new GregorianCalendar();
//		Usuario user = uDao.consultar(1);
//		Tablero tab = taDao.consultar(2);
//		Tarea tarea = new Tarea("Desarrollo", "Todo relacionado a arqui", fecha, user, tab);
//		tDao.agregar(tarea);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Tarea tarea = tDao.consultar(4);
//		Usuario user = uDao.consultar(2);
//		
//		Tarea tareaNew = new Tarea();
//		tareaNew.setId(tarea.getId());
//		tareaNew.setTitulo("Desarollo");
//		tareaNew.setFechaLim(tarea.getFechaLim());
//		tareaNew.setDescripcion("Todo lo relacionado con el BACKEND");
//		tareaNew.setUsuario(user);
//		
//		tDao.actualizar(tareaNew);
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Usuario user = uDao.consultar(2);
//		System.out.println("ID: "+user.getId()+"\n"+
//					"Nombre: "+ user.getNombre()+"\n");
//		for (Tarea tarea : user.getTarea()) {
//			System.out.println("ID: "+tarea.getId()+"\n"+
//						"Titulo: "+tarea.getTitulo()+"\n"+
//						"Descripcion: "+tarea.getDescripcion());
//		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Tablero tablero = taDao.consultar(2);
//		System.out.println("ID: "+tablero.getId()+"\n"+
//					"Nombre: "+ tablero.getTitulo()+"\n");
//		for (Tarea tarea : tablero.getTarea()) {
//			System.out.println("ID: "+tarea.getId()+"\n"+
//						"Titulo: "+tarea.getTitulo()+"\n"+
//						"Descripcion: "+tarea.getDescripcion());
//		}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Tablero tablero = taDao.consultar(1);
//		taDao.eliminar(tablero.getId());
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//		Tarea tarea = tDao.consultar(2);
//		tDao.eliminar(tarea.getId());
	}
}

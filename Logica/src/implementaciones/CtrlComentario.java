
package implementaciones;

import dao.ComentarioDAO;
import dao.DAOFactory;
import entidades.Comentario;

public class CtrlComentario {
	ComentarioDAO comentarioDAO;

	public CtrlComentario() {
		this.comentarioDAO = DAOFactory.comentariosDAO();
	}
	
	public void agregar(Comentario comentario)throws Exception{
		validarMensaje(comentario.getMensaje());
		comentarioDAO.agregar2Comentario(comentario);
	}
	
	public void validarMensaje(String mensaje)throws Exception{
		if (mensaje.equalsIgnoreCase("")) {
			throw new Exception("Introduzca un mensaje");
		}else if (mensaje.length() > 100) {
			throw new Exception("El mensaje debe de tener un máximo de 100 caracteres");
		}
	}
	
}

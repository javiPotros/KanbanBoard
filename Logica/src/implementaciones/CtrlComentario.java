
package implementaciones;

import dao.ComentarioDAO;
import dao.DAOFactory;
import entidades.Comentario;

public class CtrlComentario {
	ComentarioDAO comentarioDAO;

	public CtrlComentario() {
		this.comentarioDAO = DAOFactory.comentariosDAO();
	}
	
	public void agregar(Comentario comentario){
		comentarioDAO.agregar2Comentario(comentario);
	}
}

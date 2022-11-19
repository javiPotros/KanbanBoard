package implementaciones;

import dao.ComentarioDAO;
import dao.DAOFactory;
import entidades.Comentario;
import excepciones.DAOException;

public class CtrlComentario {

    ComentarioDAO comentarioDAO;

    public CtrlComentario() {
        this.comentarioDAO = DAOFactory.comentariosDAO();
    }

    public void agregar(Comentario comentario) throws DAOException {
        comentarioDAO.agregar(comentario);
    }
}

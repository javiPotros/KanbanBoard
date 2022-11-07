package dao;

public class DAOFactory {

    public DAOFactory() {
    }

    public UsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO();
    }

    public TareaDAO crearTareaDAO() {
        return new TareaDAO();
    }

    public TableroDAO crearTableroDAO() {
        return new TableroDAO();
    }

}

package dao;

public class DAOFactory {

    public DAOFactory() {
    }

    public static UsuarioDAO crearUsuarioDAO() {
        return new UsuarioDAO();
    }

    public static TareaDAO crearTareaDAO() {
        return new TareaDAO();
    }

    public static TableroDAO crearTableroDAO() {
        return new TableroDAO();
    }

}

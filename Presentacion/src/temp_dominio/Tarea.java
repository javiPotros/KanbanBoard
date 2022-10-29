package temp_dominio;

public class Tarea {
    
    private String nombre;
    private String usuario;

    public Tarea() {
    }

    public Tarea(String nombre, String usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Tarea{" + "nombre=" + nombre + ", usuario=" + usuario + '}';
    }
}

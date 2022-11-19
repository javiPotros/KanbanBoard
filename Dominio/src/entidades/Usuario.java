package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "rol", nullable = false, length = 50)
    private String rol;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "contrasenha", nullable = false, length = 100)
    private String contrasenha;

    @OneToMany(mappedBy = "usuario")
    private List<Tarea> tareas;

    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public Usuario(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    public Usuario(String nombre, String rol, String correo, String contrasenha) {
        this.nombre = nombre;
        this.rol = rol;
        this.correo = correo;
        this.contrasenha = contrasenha;
    }

    public Usuario(String nombre, String rol, String correo, String contrasenha, List<Tarea> tareas) {
        this.nombre = nombre;
        this.rol = rol;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.tareas = tareas;
    }

    public Usuario(Long id, String nombre, String rol, String correo, String contrasenha) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.correo = correo;
        this.contrasenha = contrasenha;
    }

    public Usuario(Long id, String nombre, String rol, String correo, String contrasenha, List<Tarea> tareas) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.tareas = tareas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    @Override
    public String toString() {
        return this.nombre + " - " + this.rol;
    }

}

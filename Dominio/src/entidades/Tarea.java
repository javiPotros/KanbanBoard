package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tarea")
public class Tarea implements Serializable {

    @Id
    @Column(name = "id_tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descripcion", nullable = true, length = 300)
    private String descripcion;

    @Column(name = "estado", nullable = false)
    private Integer estado;

    @Column(name = "fechalim", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaLim;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "tarea")
    private List<Comentario> comentario;

//    @ManyToOne(cascade = CascadeType.REFRESH)
//    @JoinColumn(name = "id_tablero", nullable = false)
//    private Tablero tablero;
    
    public Tarea() {
    }

    public Tarea(String titulo, String descripcion, Date fechaLim, Integer estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLim = fechaLim;
        this.estado = estado;
    }

    public Tarea(String titulo, String descripcion, Date fechaLim, Usuario usuario, Integer estado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLim = fechaLim;
        this.usuario = usuario;
        this.estado = estado;
    }

    public Tarea(Long id, String titulo, String descripcion, Date fechaLim, Usuario usuario, Integer estado) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaLim = fechaLim;
        this.usuario = usuario;
        this.estado = estado;
    }

    public Tarea(String titulo, String descripcion, Integer estado, Date fechaLim, Usuario usuario, List<Comentario> comentario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaLim = fechaLim;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaLim() {
        return fechaLim;
    }

    public void setFechaLim(Date fechaLim) {
        this.fechaLim = fechaLim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

//    public Tablero getTablero() {
//        return tablero;
//    }
//
//    public void setTablero(Tablero tablero) {
//        this.tablero = tablero;
//    }
    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Comentario> getComentario() {
        return comentario;
    }

    public void setComentario(List<Comentario> comentario) {
        this.comentario = comentario;
    }
}

package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tarea")
public class Tarea implements Serializable{
	
	@Id
	@Column(name = "id_tarea")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo",nullable=false,length=100)
	private String titulo;
	
	@Column(name="descripcion",nullable=true,length=300)
	private String descripcion;
	
	@Column(name="fechalim",nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar fechaLim;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable=false)
	private Usuario usuario;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name="id_tablero",nullable=false)
	private Tablero tablero;

	public Tarea() {
	}

	public Tarea(String titulo, String descripcion, Calendar fechaLim) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLim = fechaLim;
	}

	public Tarea(String titulo, String descripcion, Calendar fechaLim, Usuario usuario, Tablero tablero) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLim = fechaLim;
		this.usuario = usuario;
		this.tablero = tablero;
	}

	public Tarea(Long id, String titulo, String descripcion, Calendar fechaLim, Usuario usuario, Tablero tablero) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaLim = fechaLim;
		this.usuario = usuario;
		this.tablero = tablero;
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

	public Calendar getFechaLim() {
		return fechaLim;
	}

	public void setFechaLim(Calendar fechaLim) {
		this.fechaLim = fechaLim;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
}

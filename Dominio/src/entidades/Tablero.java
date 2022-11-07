package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tablero")
public class Tablero implements Serializable{
	
	@Id   
	@Column(name="id_tablero")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="titulo",nullable=false,length=100)
	private String titulo;
	
	@OneToMany(mappedBy="tablero",
		cascade = CascadeType.ALL)
	private List<Tarea> tarea;

	public Tablero() {
	}

	public Tablero(String titulo) {
		this.titulo = titulo;
	}

	public Tablero(String titulo, List<Tarea> tarea) {
		this.titulo = titulo;
		this.tarea = tarea;
	}

	public Tablero(Long id, String titulo, List<Tarea> tarea) {
		this.id = id;
		this.titulo = titulo;
		this.tarea = tarea;
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

	public List<Tarea> getTarea() {
		return tarea;
	}

	public void setTarea(List<Tarea> tarea) {
		this.tarea = tarea;
	}
}

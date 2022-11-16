package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
	
	@Id
	@Column(name = "id_comentario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
         @JoinColumn(name = "id_tarea", nullable = false)
	 private Tarea tarea;
	
	@Column(name = "Mensajero", nullable = false, length = 100)
	private String mensajero;
	
	@Column(name = "Mensaje", nullable = false, length = 100)
	private String mensaje;

	public Comentario(String mensajero) {
		this.mensajero = mensajero;
	}

	public Comentario() {
	}

	public Comentario(Tarea tarea, String mensajero) {
		this.tarea = tarea;
		this.mensajero = mensajero;
	}

	public Comentario(Long id, Tarea tarea, String mensajero) {
		this.id = id;
		this.tarea = tarea;
		this.mensajero = mensajero;
	}

	public Comentario(Tarea tarea, String mensajero, String mensaje) {
		this.tarea = tarea;
		this.mensajero = mensajero;
		this.mensaje = mensaje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public String getMensajero() {
		return mensajero;
	}

	public void setMensajero(String mensajero) {
		this.mensajero = mensajero;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}

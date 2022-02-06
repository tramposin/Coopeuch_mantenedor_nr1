package cl.fpd.demostracion.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table 
public class Tarea {

	@Id
	@SequenceGenerator(name = "tarea_sequence", sequenceName = "tarea_sequence", allocationSize = 1

	)

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tarea_sequence"

	)
	
	@ApiModelProperty(value = "id", hidden = true)
	private Long id;
	private String descripcion;
	private Boolean vigente;
	private LocalDate fechaCreacion;

	

	public Tarea() {
		super();
	}

	public Tarea(Long id, String descripcion, Boolean vigente, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.vigente = vigente;
		this.fechaCreacion = fechaCreacion;
	}

	
	public Tarea(String descripcion, Boolean vigente, LocalDate fechaCreacion) {
		super();
		this.descripcion = descripcion;
		this.vigente = vigente;
		this.fechaCreacion = fechaCreacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getVigente() {
		return vigente;
	}

	public void setVigente(Boolean vigente) {
		this.vigente = vigente;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Tarea [" + "id=" + id + ", descripcion=" + descripcion + ", vigente=" + vigente
				+ ", fechaCreacion=" + fechaCreacion +  "]";
	}

}

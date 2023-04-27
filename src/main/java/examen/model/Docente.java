package examen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@Table(name="docente")
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombreCompleto;

	//bi-directional many-to-one association to Asignaturaspordocente
	@OneToMany(mappedBy="docente")
	private List<Asignaturaspordocente> asignaturaspordocentes;

	public Docente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public List<Asignaturaspordocente> getAsignaturaspordocentes() {
		return this.asignaturaspordocentes;
	}

	public void setAsignaturaspordocentes(List<Asignaturaspordocente> asignaturaspordocentes) {
		this.asignaturaspordocentes = asignaturaspordocentes;
	}

	public Asignaturaspordocente addAsignaturaspordocente(Asignaturaspordocente asignaturaspordocente) {
		getAsignaturaspordocentes().add(asignaturaspordocente);
		asignaturaspordocente.setDocente(this);

		return asignaturaspordocente;
	}

	public Asignaturaspordocente removeAsignaturaspordocente(Asignaturaspordocente asignaturaspordocente) {
		getAsignaturaspordocentes().remove(asignaturaspordocente);
		asignaturaspordocente.setDocente(null);

		return asignaturaspordocente;
	}

	@Override
	public String toString() {
		return nombreCompleto;
	}
	
	

}
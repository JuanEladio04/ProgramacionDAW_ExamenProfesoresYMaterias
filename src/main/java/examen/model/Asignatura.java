package examen.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the asignatura database table.
 * 
 */
@Entity
@Table(name="asignatura")
@NamedQuery(name="Asignatura.findAll", query="SELECT a FROM Asignatura a")
public class Asignatura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String denominacion;

	//bi-directional many-to-one association to Asignaturaspordocente
	@OneToMany(mappedBy="asignatura")
	private List<Asignaturaspordocente> asignaturaspordocentes;

	public Asignatura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDenominacion() {
		return this.denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public List<Asignaturaspordocente> getAsignaturaspordocentes() {
		return this.asignaturaspordocentes;
	}

	public void setAsignaturaspordocentes(List<Asignaturaspordocente> asignaturaspordocentes) {
		this.asignaturaspordocentes = asignaturaspordocentes;
	}

	public Asignaturaspordocente addAsignaturaspordocente(Asignaturaspordocente asignaturaspordocente) {
		getAsignaturaspordocentes().add(asignaturaspordocente);
		asignaturaspordocente.setAsignatura(this);

		return asignaturaspordocente;
	}

	public Asignaturaspordocente removeAsignaturaspordocente(Asignaturaspordocente asignaturaspordocente) {
		getAsignaturaspordocentes().remove(asignaturaspordocente);
		asignaturaspordocente.setAsignatura(null);

		return asignaturaspordocente;
	}

	@Override
	public String toString() {
		return denominacion;
	}
	
	

}
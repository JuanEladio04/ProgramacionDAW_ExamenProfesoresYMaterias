package examen.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the asignaturaspordocente database table.
 * 
 */
@Entity
@Table(name="asignaturaspordocente")
@NamedQuery(name="Asignaturaspordocente.findAll", query="SELECT a FROM Asignaturaspordocente a")
public class Asignaturaspordocente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Asignatura
	@ManyToOne
	@JoinColumn(name="idAsignatura")
	private Asignatura asignatura;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="idDocente")
	private Docente docente;

	public Asignaturaspordocente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Asignatura getAsignatura() {
		return this.asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}
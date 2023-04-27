package examen.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import examen.model.Asignatura;
import examen.model.Asignaturaspordocente;

public class AsignaturaController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Asignatura> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Asignatura> query = em.createNamedQuery("Asignatura.findAll", Asignatura.class);
	    return query.getResultList();
	}

}

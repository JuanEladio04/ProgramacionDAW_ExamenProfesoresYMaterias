package examen.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import examen.model.Docente;

public class DocenteController {

	/**
	 * 
	 */
	public static List<Docente> findByLikeDescription (String description) {
		List<Docente> docentes = new ArrayList<Docente>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

	    Query q = em.createNativeQuery("SELECT * FROM docente where nombreCompleto LIKE ?", Docente.class);
	    q.setParameter(1, "%" + description + "%");

	    docentes.addAll(q.getResultList());
	    
	    em.close();

	    return docentes;
		
	}

}

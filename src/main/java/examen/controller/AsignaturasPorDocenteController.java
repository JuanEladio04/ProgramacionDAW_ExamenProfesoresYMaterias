package examen.controller;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import examen.model.Asignaturaspordocente;


public class AsignaturasPorDocenteController {
	
	/**
	 * 
	 * @return
	 */
	public static List<Asignaturaspordocente> findAll() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");	
		EntityManager em = entityManagerFactory.createEntityManager();
		
	    TypedQuery<Asignaturaspordocente> query = em.createNamedQuery("Asignaturaspordocente.findAll", Asignaturaspordocente.class);
	    return query.getResultList();
	}
	
	/**
	 * 
	 * @param string
	 */
	public static List<Asignaturaspordocente> findbyId(int idDocente) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		List<Asignaturaspordocente> apd = new ArrayList<Asignaturaspordocente>();
				
		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = ?", Asignaturaspordocente.class);

		q.setParameter(1, idDocente);

		
		try {
			apd = (List<Asignaturaspordocente>) q.getResultList();
		} catch (Exception e) {
			apd = null;
		}
		em.close();		
		return apd;
		
	}
	
	
	/**
	 * 
	 * @param string
	 */
	public static Asignaturaspordocente findByAllId(int idDocente, int idAsignatura) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");
		EntityManager em = entityManagerFactory.createEntityManager();
		Asignaturaspordocente apd = new Asignaturaspordocente();
				
		Query q = em.createNativeQuery("SELECT * FROM asignaturaspordocente where idDocente = ? and idAsignatura = ?", Asignaturaspordocente.class);

		q.setParameter(1, idDocente);
		q.setParameter(1, idAsignatura);

		
		try {
			apd = (Asignaturaspordocente) q.getSingleResult();
		} catch (Exception e) {
			apd = null;
		}
		em.close();		
		return apd;
		
	}
	
	
	/**
	 * 
	 */
	public static void realizeInsert (Asignaturaspordocente apd) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");
		EntityManager em = entityManagerFactory.createEntityManager();	
		
		em.getTransaction().begin();
		em.persist(apd);
		em.getTransaction().commit();
		em.close();
	}
	
	
	/**
	 * 
	 */
	private static void eliminacionEntidad (Asignaturaspordocente apd) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExamenJPA");

		EntityManager em = entityManagerFactory.createEntityManager();

		TypedQuery<Asignaturaspordocente> q = em.createQuery("SELECT * FROM signaturaspordocente where id = ?", Asignaturaspordocente.class);
		
		Asignaturaspordocente deleteApd = q.getSingleResult();
		
		em.getTransaction().begin();
		em.remove(deleteApd);
		em.getTransaction().commit();
		em.close();
	}

}

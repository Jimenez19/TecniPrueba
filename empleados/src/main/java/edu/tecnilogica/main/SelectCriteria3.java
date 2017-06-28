package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import edu.tecnilogica.entity.Regions;

public class SelectCriteria3 {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();
			CriteriaBuilder cb = em.getCriteriaBuilder();
			
			CriteriaQuery<Regions> cq = cb.createQuery(Regions.class);
		 	Root<Regions> root = cq.from(Regions.class);
			
		 	cq.select(root);
		 	cq.where(cb.equal(root.get("regionName"), "Europe"));
		 	TypedQuery<Regions> tq = em.createQuery(cq);
		 	List<Regions> lrg = tq.getResultList();
		 	
		 	for (Regions reg : lrg) {		 		
		 		System.out.println(reg.toString());				
			}
		 	tx.commit();
		 	em.close();
		 	emf.close();
		 	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

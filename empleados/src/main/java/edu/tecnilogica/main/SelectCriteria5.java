package edu.tecnilogica.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import edu.tecnilogica.entity.Departments;


public class SelectCriteria5 {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAFactory.getEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try {
			tx.begin();

			TypedQuery<Departments> query = em.createNamedQuery("Departments.todos", Departments.class);
			//query.setParameter("name", "Operations");

			List<Departments> ld = query.getResultList();
			for(Departments d:ld){
			System.out.println( d.getDepartmentId() + "  " +  d.getDepartmentName());
			}
			tx.commit();
			em.close();
			emf.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

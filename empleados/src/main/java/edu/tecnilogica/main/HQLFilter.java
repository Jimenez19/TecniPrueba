package edu.tecnilogica.main;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class HQLFilter {

	public static void main(String[] args) {

		Session session = HibernateFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Filter filtro = session.enableFilter("employeeFilter");
		filtro.setParameter("salary", 4000);

		Query query = session.createQuery("from Employees e");
		List<Employees> lemp=query.list();
		
		Iterator<Employees> ite=lemp.iterator();
		Employees eaux=null;
		
		while(ite.hasNext()){
			eaux = ite.next();
			System.out.println("Nombre = " + eaux.getFirstName() + " y  Salario= " + eaux.getSalary());
		}
		tx.commit();
		session.close();
		HibernateFactory.getSessionFactory().close();
	}
}

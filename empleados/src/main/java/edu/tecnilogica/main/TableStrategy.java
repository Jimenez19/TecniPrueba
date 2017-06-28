package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registrotabla;

public class TableStrategy {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			Registrotabla rg = new Registrotabla();
			Registrotabla rg1 = new Registrotabla();
			Registrotabla rg2 = new Registrotabla();
			
			sesion.save(rg);
			sesion.save(rg1);
			sesion.save(rg2);
			
			tx.commit();
			sesion.close();
			sf.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

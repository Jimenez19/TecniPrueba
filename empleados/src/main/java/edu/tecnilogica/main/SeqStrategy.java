package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registroseq;

public class SeqStrategy {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			Registroseq rg = new Registroseq();
			Registroseq rg1 = new Registroseq();
			Registroseq rg2 = new Registroseq();
			
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

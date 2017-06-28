package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;

public class UUIDStrategy {

	public static void main(String[] args) {
		
		SessionFactory sf = HibernateFactory.getSessionFactory();
		
		try {
			
			Session sesion = sf.openSession();
			Transaction tx = sesion.beginTransaction();
			
			Registro rg = new Registro();
			Registro rg1 = new Registro();
			Registro rg2 = new Registro();
			
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

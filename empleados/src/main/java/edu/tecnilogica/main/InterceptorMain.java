package edu.tecnilogica.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Registro;
import edu.tecnilogica.entity.Registrotabla;

public class InterceptorMain {

	public static void main(String[] args) {
		
	
	SessionFactory sf = HibernateFactory.getSessionFactory();

	Session session = sf.withOptions().interceptor(new MyInterceptor()).openSession();

	Transaction tx = session.beginTransaction();
	
	Registrotabla registro = new Registrotabla();
	session.save(registro);
	tx.commit();
	session.close();
	sf.close();
	}
}

package edu.tecnilogica.main;



import java.math.BigDecimal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;


public class AumentoSalario {
	
	
	//Sabiendo que los empleados van del 100 al 207, hacer un algoritmo con la sesion de 
	//Hibernate que actualice el salario a todos un 107%
	public static void main(String[] args) {
		
		SessionFactory sf = null;
		
			sf = HibernateFactory.getSessionFactory();		
			Session session = sf.openSession();
			Transaction tx = null;
		try { //"Transacción"
			
			tx = session.beginTransaction();
			for (int i=100; i< 207; i++){
			Employees empleado = session.get(Employees.class, i);
			BigDecimal salario_actual = empleado.getSalary();
			BigDecimal salario_nuevo = salario_actual.multiply(new BigDecimal (1.07));
			empleado.setSalary(salario_nuevo);
			}
					
			//session.save(tx);
			tx.commit();
			
			
			
		} catch (Exception e) {
		
			tx.rollback();
			e.printStackTrace();
			
		}finally {			
			session.close();
		}
		}

}

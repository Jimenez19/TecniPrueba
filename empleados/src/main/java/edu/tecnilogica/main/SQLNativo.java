package edu.tecnilogica.main;

import java.util.List;

import org.hibernate.Filter;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.tecnilogica.entity.Employees;

public class SQLNativo {

	public static void main(String[] args) {

		Session session = HibernateFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		//SQLQuery qnativa = session.createSQLQuery("SELECT employee_id, email FROM Employees");
		SQLQuery qnativa = session.createSQLQuery("SELECT * FROM employees");
		qnativa.addEntity(Employees.class);
		Filter filtro = session.enableFilter("employeeFilter");
		filtro.setParameter("salary", 40000);
		
		List<Employees> empleados= qnativa.list();
		for (Employees empleado : empleados){
			System.out.println(empleado.getFirstName() + "  " + empleado.getEmail());
			
		}
		
		tx.commit();
		session.close();
		HibernateFactory.getSessionFactory().close();
	}
}

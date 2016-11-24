package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Customer;
import util.HibernateUtil;

public class CustomerTest {

	public static void main(String[] args) {
		//Create two tables associated with the model
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = new Customer();
		customer.setAddress("istanbul");
		customer.setName("levent");
		session.persist(customer);
		session.getTransaction().commit();
		session.close();

	}

}

package SecondaryTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class CustomerTest {

	public static void main(String[] args) {
		//Create two tables associated with the model
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer = new Customer();
		customer.setAddress("ankara");
		customer.setName("kevser");
		session.persist(customer);
		session.getTransaction().commit();
		session.close();

	}

}

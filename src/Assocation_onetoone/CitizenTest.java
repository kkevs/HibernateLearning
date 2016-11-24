package Assocation_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class CitizenTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CitizenAddress address = new CitizenAddress();
		address.setCity("Ankara");
		address.setRoad("Cad");
		address.setStreet("sokak");
		address.setZipcode("34000");

		Citizen citizen = new Citizen();
		citizen.setName("kevser");
		citizen.setSurname("kose");
		citizen.setCitizenAddress(address);

		// cascadeType.ALL oldugu icin session.save(address1);
		// ve session.save(address2) dememize gerek yok.

		session.persist(citizen);
		session.getTransaction().commit();
		session.close();
	}

}

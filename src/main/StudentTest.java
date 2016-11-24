package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Address;
import model.Student;
import util.HibernateUtil;

public class StudentTest {

	public static void main(String[] args) {
		//Embedded & Embeddable features
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Address address = new Address();
		address.setStreet("sokak");
		address.setRoad("cadde");
		address.setCity("sehir");
		address.setZipcode("123");

		Student student = new Student();
		student.setStudentName("kevser");
		student.setStudentSurname("kose");
		student.setStudentAddress(address);

		session.persist(student);
		session.getTransaction().commit();
		session.close();
	}

}

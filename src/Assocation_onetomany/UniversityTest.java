package Assocation_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class UniversityTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		University university = new University("Gazi University", "Engineering Faculty", "Computer Dept.");

		Student student1 = new Student("Kevser", "kose");
		Student student2 = new Student("Furkan", "Kose");

		university.getStudentRecord().add(student1);
		university.getStudentRecord().add(student2);

		student1.setUniversity(university);
		student2.setUniversity(university);
		session.persist(university);
		session.getTransaction().commit();
		session.close();
	}

}

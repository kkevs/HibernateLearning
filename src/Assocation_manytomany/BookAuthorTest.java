package Assocation_manytomany;

import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class BookAuthorTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Calendar publicationDate = Calendar.getInstance();

		publicationDate.set(1990, Calendar.JANUARY, 1);
		Book book1 = new Book();
		book1.setPages(500);
		book1.setTitle("BookTitle1");
		book1.setPublicationDate(publicationDate);

		Author author1 = new Author();
		author1.setName("Author1");
		author1.setSurname("Surname1");

		book1.getAuthors().add(author1);

		session.save(book1);

		session.save(author1);

		session.getTransaction().commit();
	}
}

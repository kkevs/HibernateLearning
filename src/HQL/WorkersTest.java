package HQL;

import java.util.Iterator;
import java.util.List;

import javax.persistence.NamedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class WorkersTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		// Session session = sessionFactory.openSession();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		Workers workers;
		for (int i = 1; i <= 10; i++) {
			workers = new Workers("WorkerName " + i, "WorkerSurname" + i, i * 50);
			session.persist(workers);
		}
		// FirstLesson
		// String hql = "FROM HQL.Workers";
		// Query query = session.createQuery(hql);
		// List results = query.list();
		//
		// for (Iterator it = (results).iterator(); it.hasNext();) {
		// Workers i = (Workers) it.next();
		// System.out.println(i.getName() + " " + i.getSurname() + " " +
		// i.getSalary());
		//
		// }

		// SecondLesson
		Query query = session.getNamedQuery("Workers.byId");
		query.setInteger(0, 5);
		List<Workers> list = (List) query.list();
		for (Workers worker : list) {
			System.out.println(worker.getName() + " " + worker.getSurname() + " " + worker.getSalary());
		}

		query = session.getNamedQuery("Workers.byName");
		query.setString(0, "WorkerName 7");
		list = (List) query.list();
		for (Workers worker : list) {
			System.out.println(worker.getName() + " " + worker.getSurname() + " " + worker.getSalary());
		}

		session.getTransaction().commit();
		// session.close();
	}
}

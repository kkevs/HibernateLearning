package main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Accounts;
import model.CompoundKey;
import util.HibernateUtil;

public class AccountTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		CompoundKey compoundKey = new CompoundKey(1,1233);
		Accounts accounts = new Accounts();
		accounts.setCompoundKey(compoundKey);
		accounts.setAccountBalance(123);

		session.persist(accounts);
		session.getTransaction().commit();
		session.close();
	}

}

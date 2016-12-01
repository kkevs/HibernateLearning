package CriteriaQueries;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

public class CriteriaTest {

	public static void main(String[] args)
			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		CriteriaTest test = new CriteriaTest();
		//
		// String action = "executeEqualsCriteria"; // action change method name
		// if (action.equalsIgnoreCase("addRecord")) {
		// test.addRecord(session);
		// } else {
		// Method method = CriteriaTest.class.getMethod(action, new Class[] {
		// Session.class });
		// method.invoke(test, new Object[] { session });
		// }
		test.addRecord(session);
		session.getTransaction().commit();
		session.close();
	}

	public void addRecord(Session session) {

		Employee emp1 = new Employee();
		emp1.setEmp_name("Kevser");
		emp1.setEmp_surname("Kose");
		emp1.setSalary(1000);
		session.save(emp1);

		Employee emp2 = new Employee();
		emp2.setEmp_name("Furkan");
		emp2.setEmp_surname("Kose");
		emp2.setSalary(1500);
		session.save(emp2);

	}

	public void executeSimpleCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		List results = crit.list();
		System.out.println(results.toString());
		displayCriteriaList(results);
	}

	public void displayCriteriaList(List<Employee> list) {
		Iterator<Employee> iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No Results..");
			return;
		}
		while (iter.hasNext()) {
			Employee employee = (Employee) iter.next();
			String msg = employee.getEmp_name() + " " + employee.getEmp_surname() + "\t" + employee.getSalary();
			System.out.println(msg);
		}
	}

	public void executeEqualsCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.eq("emp_name", "Kevser"));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeNotEqualsCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.ne("emp_name", "Kevser"));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeLikePatternCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.like("emp_name", "Ke%"));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeGreaterThanCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.gt("salary", 1400));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeAndCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.gt("salary", 1000));
		// Ýki tane Restrictions kullandýk bunun anlamý 1000 den buyuk R ile
		// baþlayan
		crit.add(Restrictions.like("emp_name", "R%"));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeOrCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		Criterion salary = Restrictions.gt("salary", 1600);
		Criterion name = Restrictions.like("emp_name", "R%");
		LogicalExpression orExp = Restrictions.or(salary, name);
		crit.add(orExp);
		List results = crit.list();
		displayCriteriaList(results);

	}

	public void executeDisjunctionCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		Criterion salary = Restrictions.gt("salary", 1500);
		Criterion name = Restrictions.like("emp_name", "K%");
		Criterion surname = Restrictions.ilike("emp_surname", "K%");
		Disjunction disjunction = Restrictions.disjunction();
		disjunction.add(salary);
		disjunction.add(name);
		disjunction.add(surname);
		crit.add(disjunction);
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeOrderCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		crit.add(Restrictions.gt("salary", 1400));
		crit.addOrder(Order.desc("salary"));
		List results = crit.list();
		displayCriteriaList(results);
	}

	public void executeAggregatesCriteria(Session session) {
		Criteria crit = session.createCriteria(Employee.class);
		ProjectionList projList = Projections.projectionList();
		projList.add(Projections.max("salary"));
		projList.add(Projections.min("salary"));
		projList.add(Projections.avg("salary"));
		projList.add(Projections.countDistinct("emp_name"));
		crit.setProjection(projList);
		// different use
		List results = crit.list();
		displayObjectsList(results);
	}

	public void displayObjectsList(List list) {
		Iterator iter = list.iterator();
		if (!iter.hasNext()) {
			System.out.println("No objects to display.");
			return;
		}
		while (iter.hasNext()) {
			Object[] obj = (Object[]) iter.next();
			for (int i = 0; i < obj.length; i++) {
				System.out.print(obj[i] + " ");
			}
			System.out.println();
		}

	}
}

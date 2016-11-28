package Inheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class VehicleTest {

	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("FORD");

		TwoWheeler bike = new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setSteeringHandle("bike steering handle");

		FourWheeler car = new FourWheeler();
		car.setVehicleName("Porsche");
		car.setSteeringWheel("Porshe Streering Wheel");

		session.persist(vehicle);
		session.persist(car);
		session.persist(bike);

		session.getTransaction().commit();
		session.close();
	}

}

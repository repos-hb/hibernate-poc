package client;

import entity.Address;
import entity.House;
import entity.Person;
import entity.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EmbeddedTestClient {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction txn = session.getTransaction();
		txn.begin();

		Address address = new Address("200 Verizon Way", "NY", "85123");
//		Person person = new Person("Ruby", address);

		House house = new House(address, new Room(11,10,7));

		session.save(house);

		txn.commit();
		session.close();
		sessionFactory.close();

	}
}

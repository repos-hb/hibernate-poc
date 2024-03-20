package compositepk;

import enums.Employee;
import enums.EmployeeStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class CarClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();

					Car car = new Car();
					car.setId(new CarPrimaryKey("999999999999","264864824682"));
					car.setMaker("TATA");
					car.setModel("Harrier");

					session.persist(car);

	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













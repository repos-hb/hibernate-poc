package enums;

import mapping.manytomany.Actor;
import mapping.manytomany.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class EmployeeClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();

					Employee employee = new Employee();
					employee.setName("hirak");
					employee.setStatus(EmployeeStatus.FULLTIME);

					Employee employee2 = new Employee();
					employee2.setName("basant");
					employee2.setStatus(EmployeeStatus.PARTTIME);

					Employee employee3 = new Employee();
					employee3.setName("sasi");
					employee3.setStatus(EmployeeStatus.CONTRACT);

					session.persist(employee);
					session.persist(employee2);
					session.persist(employee3);

	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













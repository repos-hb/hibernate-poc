package mapping.onetoone;

import mapping.Guide;
import mapping.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;


public class OneToOneMappingTestClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        			//Person having 1 Address    
        			
        			Passport passport = new Passport();
					passport.setValid(true);
					passport.setPassportNumber("9999999999");

					Customer customer = new Customer();
					customer.setName("sumit");
					customer.setPassport(passport);
        	
        			session.persist(customer);
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













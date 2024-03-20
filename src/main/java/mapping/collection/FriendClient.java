package mapping.collection;

import entity.Address;
import enums.Employee;
import enums.EmployeeStatus;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;


public class FriendClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();

					Friend friend = new Friend();
					friend.setName("jack");
					friend.setEmail("jack@abc");
					friend.setNicknames(new ArrayList<>(Arrays.asList("jo","jacky","jim")));

					friend.getAddressList().add(new Address("NNR","KOL","28"));
					friend.getAddressList().add(new Address("RSR","DEL","20"));

					session.persist(friend);

	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













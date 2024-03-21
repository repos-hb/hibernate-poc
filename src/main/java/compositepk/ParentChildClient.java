package compositepk;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ParentChildClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();

					Child child1 = new Child();
					Parent parent =new Parent();
					ParentPK parentPK = new ParentPK("bob","thomas");
					parent.setParentPK(parentPK);
					parent.setAge(35);
					parent.getChildren().add(child1);

					session.persist(parent);
//					session.persist(child2);

	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













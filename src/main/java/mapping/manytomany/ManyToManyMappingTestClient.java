package mapping.manytomany;

import mapping.onetoone.Customer;
import mapping.onetoone.Passport;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class ManyToManyMappingTestClient {
	public static void main(String[] args) {
		
				Session session = HibernateUtil.getSessionFactory().openSession();
        		Transaction txn = session.getTransaction();
        		try {
        			txn.begin();
        			//Person having 1 Address    
        			
        			Actor actor = new Actor();
					actor.setName("Leo");

//					Actor actor1 = new Actor();
//					actor1.setName("Bale");

					Movie movie = new Movie();
					movie.setTitle("titanic");
//					movie.getActors().add(actor);
					actor.setMovies(movie);

//					Movie movie1 = new Movie();
//					movie1.setTitle("batman");
//					movie1.getActors().add(actor1);

//        			session.persist(movie);
					session.persist(actor);
	        		txn.commit();
        		}	catch(Exception e) {
	        			if(txn != null) { txn.rollback(); }
	        			e.printStackTrace();
        		}	finally {
        				if(session != null) { session.close(); }
        		}
	
	}
}













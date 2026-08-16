package Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Student;

public class Application {
	public static void main(String[] args) {
		//step 1:Create Configuration Object
		Configuration config = new Configuration();
		
		//Step2
		config.configure();
		
		//step 3 : get session Factory
		SessionFactory sessionFactory = config.buildSessionFactory();
		
		//step 4:Get Session Object From Session factory
		Session session = sessionFactory.openSession();
		
		//Step 5:Begin a Transaction From The Session
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(1);
		student.setsName("Varun");
		student.setsCity("Mumbai");
		
		//Step 6 :Perform Insert Type Operations
		session.persist(student);
		
		//Step 7 : Performig Transactions operations
		transaction.commit();
		
		//Step 8 : CLose Resources and Session
		session.close();
		
	}

}

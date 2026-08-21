package Application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Student;

public class Application {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		Session session=null;
		Transaction transaction = null;
		boolean flag = false;
		
		try 
		{
			session = sessionFactory.openSession();
			
			transaction=session.beginTransaction();
			//method 1 load or get
//			Student s1 = new Student();
//			session.load(s1,1);
//			System.out.println("name"+s1.getsName());
//			System.out.println("id"+s1.getSid());
//			System.out.println("city"+ s1.getsCity());
//			
			
			
//			//method 2 find 
//			Student s2 = session.find(Student.class,1);
//			System.out.println("name"+s2.getsName());
//			System.out.println("id"+s2.getSid());
//			System.out.println("city"+ s2.getsCity());
//			
			//method 3 get reference
			Student s3 = session.getReference(Student.class,1);
			System.out.println("name"+s3.getsName());
			System.out.println("id"+s3.getSid());
			System.out.println("city"+ s3.getsCity());
			
			
			

		}
		catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			
			if(flag==true) {
				 transaction.commit();
			  }else{
				 transaction.rollback();
			 }
			session.close();
			sessionFactory.close();
		}
	}

}

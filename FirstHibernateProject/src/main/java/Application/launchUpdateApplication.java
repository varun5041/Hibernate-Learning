package Application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Student;

public class launchUpdateApplication {
	public static void main(String[] args) 
	{
		SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(Student.class).
				buildSessionFactory();
		Transaction transaction = null;
		Session session=null;
		boolean flag1=false;
		try {
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			Student st= new Student();
			st.setSid(2);
			session.remove(st);
			
			flag1=true;
			
			
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(flag1) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			session.close();
			sessionFactory.close();
		}
		
		

	}
}

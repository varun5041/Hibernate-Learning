package Application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Employee;


public class Application {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().
												addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session=null;
		Transaction transaction = null;
		boolean flag = false;
		
		try {
			session=sessionFactory.openSession();
			transaction=session.beginTransaction();
			
			Employee e2 = new Employee();
			
			e2.setEid(2);
			e2.setEname("Kun");
			e2.setEcity("Dill");
			e2.setEage(2);
			
			session.persist(e2);
			flag=true;
			
		}catch(HibernateException e) {
			e.printStackTrace();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(flag==true) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
		}
	}
}

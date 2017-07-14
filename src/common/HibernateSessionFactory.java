package common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	
	static{
		System.out.println("--------启动会话工厂");
		
		try{
			
			cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
			System.out.println("---------启动链接结束");
			
		}catch(HibernateException e){
			
			
			throw new RuntimeException("Hibernate初始化失败",e);
			
			
		}
		
		
		
		
		
	}//static静态代码段
	
	
	
	public static Session getSession(){
		
		
		return sessionFactory.getCurrentSession();
		
		
		
		
	}
	
	
	
}

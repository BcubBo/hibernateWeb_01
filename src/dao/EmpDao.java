package dao;

import common.HibernateSessionFactory;
import po.Emp;

public class EmpDao {
	
	
	public Emp findEmpById(java.io.Serializable id){
		
		
		return (Emp)HibernateSessionFactory.getSession().get(Emp.class,id);
		
		
		
		
	}//findEmpById结尾
	
	
	public void save(Emp emp){
		
		
		HibernateSessionFactory.getSession().save(emp);
		
		
		
	}//save方法
	
	
	public void update(Emp emp){
		
		
		HibernateSessionFactory.getSession().update(emp);
	}//update方法结尾
	
	public void delete(Emp emp){
		
		HibernateSessionFactory.getSession().delete(emp);
		
		
		
		
		
	}
	
	
	

}

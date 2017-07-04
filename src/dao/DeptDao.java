package dao;

import common.HibernateSessionFactory;
import po.Dept;

public class DeptDao {
	
	public Dept findDeptById(java.io.Serializable id){
		
		return (Dept)HibernateSessionFactory.getSession().get(Dept.class, id);
		
		
		
		
		
		
		
	}//findDeptById结尾
	
	
	
	
	public void save(Dept dept){
		
		
		
		HibernateSessionFactory.getSession().save(dept);
		
		
		
	}//save方法
	
	
	public void update(Dept dept){
		
		HibernateSessionFactory.getSession().update(dept);
		
		
		
	}//update方法结尾
	
	
	public void delete(Dept dept){
		
		Dept toDelete = (Dept)HibernateSessionFactory.getSession().get(Dept.class, dept.getDeptNo());
	//如果想让级联删除操作更顺畅，要先进行查询
		HibernateSessionFactory.getSession().delete(toDelete);
		
	
	
	
	}//delete结尾
	
	
}

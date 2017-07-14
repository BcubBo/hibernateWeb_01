package biz;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;
import dao.DeptDao;
import po.Dept;
import po.Emp;

public class DeptBiz {
	
	private DeptDao dao  = new DeptDao();
	public void saveDept(Dept dept){
			
		Transaction tx = null;
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.save(dept);
			
			tx.commit();
			System.out.println("添加成功");
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx != null){
				
				tx.rollback();
				
				
				
			}
		}
	
		
		
		
	}//saveDept结尾
	
	
	public void modifyDept(Dept dept){
		
		Transaction tx = null;
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.update(dept);
			
			tx.commit();
			
			System.out.println("<----\t修改成功\t---->");
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			
			if(tx != null){
				
				tx.rollback();
				System.out.println("<----\t已回滚\t---->");
				
			}
			
			
		}
		
		
		
	}//modifyDept结尾
	
	public void deleteDept(Dept dept){
		
		Transaction tx = null;
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.delete(dept);
			
			tx.commit();
			
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx != null){
				
				tx.rollback();
			}
			
			
		}
		
		
		
		
		
		
	}//deleteDept结尾
	
	public Dept findDeptById(java.io.Serializable id){
		
		Transaction tx = null;
		Dept dept = null;
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dept = dao.findDeptById(id);
			System.out.println("<-----\t"+dept.getDeptName()+"\t----->");
			
			Set<Emp> emps  = dept.getEmps();
			
			for(Iterator<Emp> it = emps.iterator();it.hasNext();){
				
				Emp e = it.next();
				System.out.println("<-----\t"+e.getEmpName()+"\t----->");
				
				
				
			}
			
			tx.commit();
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx != null){
				
				tx.rollback();
				
				
			}
			
			
		}
		
		
		
		return dept;
		
		
		
		
		
	}//findDeptById结尾
	
	
	public void addNewDept(Dept dept){
		
		Transaction tx = null;
		
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.save(dept);
			Set<Emp> emps = dept .getEmps();
			//检查是否有集合需要进行处理，如果有需要进行保存
/*			if(emps.size()!=0){

				dao.save(dept);
				//循环保存
				
				for(Iterator<Emp> it = emps.iterator();it.hasNext();){
					//可迭代的条件
					Emp e = it.next();
					
					//save(e);
					
					
					
					
				}
			}*/
			
			tx.commit();
			System.out.println("<----添加成功---->");
			
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			
			if(tx != null){
				
				tx.rollback();
				
				
				
			}
			
		}
		
		
		
		
		
		
	}//addNewDept结尾
	
	
}

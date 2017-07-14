package biz;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;
import dao.DeptDao;
import dao.EmpDao;
import po.Dept;
import po.Emp;

public class EmpBiz {
	private EmpDao dao = new EmpDao();
	public Emp findById(java.io.Serializable id){
		
		
		Transaction tx = null;
		
		Emp emp = null;
		
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			emp = dao.findEmpById(id);

			System.out.println(emp.getEmpName()+"\t"+emp.getDept().getDeptName());
			
		
			tx.commit();
			
			
			
		}catch(HibernateException e){
			
			
			e.printStackTrace();
			if(tx!=null){
				
				
				tx.rollback();
				
				
			}
			
			
		}
		
		return emp;
		
		
	}//findById方法结尾
	
	
	
	public void addNewEmp(Emp emp){
		
		
		Transaction tx = null;
		
	
		
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			Dept dept = new DeptDao().findDeptById(emp.getDept().getDeptNo());
			
			emp.setDept(dept);
			dao.save(emp);
			
			tx.commit();
			
			System.out.println("成功");
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx!=null){
				
				tx.rollback();
				
			}
			
		}
		
		
		
		
		
		
		
		
	}//addNewEmp方法结尾
	
	
	public void modifyEmp(Emp emp){
		
		
		Transaction tx = null;
		
	
		
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.update(emp);
			
			tx.commit();
			
			System.out.println("更新成功");
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx!=null){
				
				tx.rollback();
				
			}
			
		}
		
		
		
		
		
		
		
		
	}//modifyEmp方法结尾	
	
	
	
public void delete(Emp emp){
		
		
		Transaction tx = null;
		
	
		
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			dao.delete(emp);
			
			tx.commit();
			
			System.out.println("删除成功");
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx!=null){
				
				tx.rollback();
				
			}
			
		}
		
		
		
		
		
		
		
		
	}//deleteEmp方法结尾		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//类结尾

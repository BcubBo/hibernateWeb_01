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
			

			
			dao.save(dept);
			

			System.out.println("添加成功");

	
		
		
		
	}//saveDept结尾
	
	
	public void modifyDept(Dept dept){
		
		
			dao.update(dept);
			

		
		
		
	}//modifyDept结尾
	
	public void deleteDept(Dept dept){
		

			dao.delete(dept);
			

		
		
		
		
		
	}//deleteDept结尾
	
	public Dept findDeptById(java.io.Serializable id){
		Dept dept = dao.findDeptById(id);
			System.out.println("<-----\t"+dept.getDeptName()+"\t----->");
			
			Set<Emp> emps  = dept.getEmps();
			
			for(Iterator<Emp> it = emps.iterator();it.hasNext();){
				
				Emp e = it.next();
				System.out.println("<-----\t"+e.getEmpName()+"\t----->");
				
				
				
			}

		
		
		
		return dept;
		
		
		
		
		
	}//findDeptById结尾
	
	
	public void addNewDept(Dept dept){
			
			dao.save(dept);
//			Set<Emp> emps = dept .getEmps();
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
			
			System.out.println("<----添加成功---->");
			
		
		
		
		
		
		
	}//addNewDept结尾
	
	
}

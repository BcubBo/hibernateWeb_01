package biz;

import dao.DeptDao;
import dao.EmpDao;
import po.Dept;
import po.Emp;

public class EmpBiz {
	private EmpDao dao = new EmpDao();
	public Emp findById(java.io.Serializable id){
		Emp emp = dao.findEmpById(id);

			System.out.println(emp.getEmpName()+"\t"+emp.getDept().getDeptName());
		
		return emp;
		
		
	}//findById方法结尾
	
	
	
	public void addNewEmp(Emp emp){
		
			Dept dept = new DeptDao().findDeptById(emp.getDept().getDeptNo());
			
			emp.setDept(dept);
			dao.save(emp);
			
			
			System.out.println("成功");
	}//addNewEmp方法结尾
	
	
	public void modifyEmp(Emp emp){
		
		
			
			dao.update(emp);
			
			
			System.out.println("更新成功");
		
	}//modifyEmp方法结尾	
	
	
	
public void delete(Emp emp){
		
			
			dao.delete(emp);
			
			
			System.out.println("删除成功");

		
	}//deleteEmp方法结尾		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//类结尾

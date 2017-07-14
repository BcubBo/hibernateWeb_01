package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.DeptBiz;
import po.Dept;

public class CtrlServlet extends HttpServlet {
	private static final long serialVersionUID = 8742839634059944545L;

	public CtrlServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request,response);
		
		
		
	}//doGet方法

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String strId =request.getParameter("id");
		Dept dept = new DeptBiz().findDeptById(Byte.parseByte(strId));
		
		request.setAttribute("result", dept);
		request.getRequestDispatcher("/index.jsp").forward(request,response);
		
		
		
		
		
	}//doPost方法

}

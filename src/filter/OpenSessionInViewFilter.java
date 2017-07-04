package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;
import dao.DeptDao;

public class OpenSessionInViewFilter implements Filter {
	private DeptDao dao  = new DeptDao();
    public OpenSessionInViewFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		Transaction tx = null;
		try{
			
			tx = HibernateSessionFactory.getSession().beginTransaction();
			
			
			chain.doFilter(request, response);
			tx.commit();
			
			
		}catch(HibernateException e){
			
			e.printStackTrace();
			if(tx != null){
				
				tx.rollback();
				
				
				
			}
		}
		
		
		
		
		//chain.doFilter(request, response);
		System.out.println("<----在视图中开启会话---->");
	}//

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

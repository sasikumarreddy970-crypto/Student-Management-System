package com.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.StudentDao;

/**
 * Servlet Filter implementation class StudentChecking
 */
@WebFilter("/addStudent")
public class StudentChecking extends HttpFilter implements Filter {
       
   
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		try {
			 HttpServletRequest req =
		                (HttpServletRequest) request;

		        HttpServletResponse res =
		                (HttpServletResponse) response;
			String srn=req.getParameter("srn");
			HttpSession session=req.getSession();
			String userName=session.getAttribute("userName").toString();
			StudentDao studentDao=new StudentDao();
			if(studentDao.haveStudent(srn, userName)) {

				request.setAttribute("srnError", "have student please Register Other");
				RequestDispatcher reqDisp=request.getRequestDispatcher("AddStudent.jsp");
				reqDisp.forward(request, response);
				return;
				
			}
			else {
				chain.doFilter(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	

}

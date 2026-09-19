package com.filters;

import java.io.IOException;
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

@WebFilter("/deleteStudent")
public class DeleteStudent extends HttpFilter implements Filter {
       
    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		
		
		try {
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse res=(HttpServletResponse) response;
			String srn=req.getParameter("srn");
			HttpSession session=req.getSession();
			String userName=session.getAttribute("userName").toString();
			StudentDao studentDao =new StudentDao();
			if(!studentDao.haveStudent(srn, userName)) {
				request.setAttribute("deleteError", "Hey Srn Not Found Try Again");
				request.removeAttribute("acceptNote");
				RequestDispatcher reqDisp=req.getRequestDispatcher("DeleteStudent.jsp");
						reqDisp.forward(request, response);
						return;
			}
			else {
				chain.doFilter(request, response);
			}
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}

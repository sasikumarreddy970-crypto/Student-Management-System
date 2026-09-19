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

import com.Dao.CredentialDao;

/**
 * Servlet Filter implementation class usernameChecking
 */
@WebFilter("/register")
public class usernameChecking extends HttpFilter implements Filter {
       
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String username=request.getParameter("username");
		try {
			CredentialDao credDao=new CredentialDao();
			if(credDao.haveUser(username)) {
				request.setAttribute("usernameError", "UserName is Already Exists");
				RequestDispatcher reqDisp=request.getRequestDispatcher("Register.jsp");
				reqDisp.forward(request, response);
				return;
			}
			else {
				chain.doFilter(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

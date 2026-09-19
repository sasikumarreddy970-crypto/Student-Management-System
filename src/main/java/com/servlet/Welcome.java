package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.CredentialDao;
import com.Dao.StudentDao;
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {

	protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException {

				try {
				
					HttpSession session = request.getSession(false);
				
					if(session == null ||
						  session.getAttribute("userName") == null){
						
						   response.sendRedirect("Login.jsp");
						   return;
					}
					
					String userName =
					   (String) session.getAttribute("userName");
					
					CredentialDao credDao = new CredentialDao();
					
					String name =
					   credDao.getNameByuserName(userName);
					
					int users =
					   credDao.countUsers();
					
					StudentDao studDao = new StudentDao();
					
					int totalStudents =
					   studDao.countStudents(userName);
					
					request.setAttribute("name", name);
					request.setAttribute("activeUsers", users);
					request.setAttribute("totalStudents", totalStudents);
					request.setAttribute("totalCourses",4);
					
					request.getRequestDispatcher("Welcome.jsp")
					      .forward(request, response);

				} catch (Exception e) {
					e.printStackTrace();
				}
}
}

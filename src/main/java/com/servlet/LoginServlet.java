package com.servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import com.Dao.CredentialDao;
import com.databasesClasses.Credential;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=null;
		String email=null;
		String userName=request.getParameter("username");
		String passWord=request.getParameter("password");
		Credential cred=new Credential(name,email,userName,passWord);
		CredentialDao credDao;
		try {
			credDao = new CredentialDao();
			if(credDao.checkLogin(cred)) {

				
				HttpSession session=request.getSession();
				session.setAttribute("name", credDao.getNameByuserName(cred.getUsername()));
				session.setAttribute("userName", cred.getUsername());
				response.sendRedirect("Welcome");
			}
			else {
				response.sendRedirect("Register.jsp");
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}

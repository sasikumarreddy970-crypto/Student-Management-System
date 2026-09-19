package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.StudentDao;
import com.databasesClasses.Student;

/**
 * Servlet implementation class updateStudent
 */
@WebServlet("/updateStudent")
public class updateStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session=request.getSession();
			String userName=session.getAttribute("userName").toString();
			String srn=request.getParameter("srn");
			String firstName=request.getParameter("firstName");
			String lastName=request.getParameter("lastName");
			int age=Integer.parseInt(request.getParameter("age"));
			String branch=request.getParameter("branch");
			Student student=new Student(srn,firstName,lastName,age,branch,userName);
			StudentDao studDao=new StudentDao();
			studDao.updateStudent(student);
			response.sendRedirect("viewStudent");
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}

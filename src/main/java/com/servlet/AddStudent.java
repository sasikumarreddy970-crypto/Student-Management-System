package com.servlet;

import java.io.IOException;

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
 * Servlet implementation class AddStudent
 */
@WebServlet("/addStudent")
public class AddStudent extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String userName=session.getAttribute("userName").toString();
		String srn=request.getParameter("srn");
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		int age=Integer.parseInt(request.getParameter("age"));
		String branch=request.getParameter("branch");
		Student student=new Student(srn,firstName,lastName,age,branch,userName);
		try {
			StudentDao studentDao=new StudentDao();
			studentDao.insertStudent(student);
			request.setAttribute("srnError", "Inserted.. Clear the details To Insert Another");
			RequestDispatcher reqDisp=request.getRequestDispatcher("AddStudent.jsp");
			reqDisp.forward(request, response);
			return;
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}

package com.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
 * Servlet implementation class viewServlet
 */
@WebServlet("/viewStudent")
public class viewServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			HttpSession session=request.getSession();
			String userName=session.getAttribute("userName").toString();
			StudentDao studDao=new StudentDao();
			List<Student> list=studDao.getStudents(userName);
			if(list.size()>0) {
				request.setAttribute("students", list);
				RequestDispatcher reqDisp=request.getRequestDispatcher("viewStudent.jsp");
				reqDisp.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}

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
 * Servlet implementation class editStudent
 */
@WebServlet("/editStudent")
public class editStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String srn=request.getParameter("srn");
			HttpSession session=request.getSession();
			String userName=(String) session.getAttribute("userName");
			StudentDao studDao=new StudentDao();
			Student student=studDao.getStudentBySrn(srn, userName);
			request.setAttribute("student", student);
			RequestDispatcher reqDisp=request.getRequestDispatcher("updateStudent.jsp");
			reqDisp.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

}

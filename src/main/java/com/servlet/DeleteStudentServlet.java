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

/**
 * Servlet implementation class DeleteStudentServlet
 */
@WebServlet("/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			String srn=request.getParameter("srn");
			HttpSession session=request.getSession();
			String userName=session.getAttribute("userName").toString();
			StudentDao studentDao =new StudentDao();
			studentDao.DeleteStudent(srn, userName);
			request.setAttribute("acceptNote", "Hey U Deleted "+srn);
			request.removeAttribute("deleteError");
			RequestDispatcher reqDisp=request.getRequestDispatcher("DeleteStudent.jsp");
			reqDisp.forward(request, response);
			return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

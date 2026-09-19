package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteStudent
 */
@WebServlet("/deleteStudentForward")
public class deleteStudentForward extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String srn=request.getParameter("srn");
		request.setAttribute("srn", srn);
		RequestDispatcher reqDsip=request.getRequestDispatcher("DeleteStudent.jsp");
		reqDsip.forward(request, response);
		
		
		
		
	}

}

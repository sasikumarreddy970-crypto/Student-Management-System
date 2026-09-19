package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.StudentDao;
import com.databasesClasses.Student;

/**
 * Servlet implementation class searchStudent
 */
@WebServlet("/searchStudent")
public class searchStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		try {
			HttpSession session=request.getSession();
			String userName=(String) session.getAttribute("userName");
			String srn=request.getParameter("srn");
			StudentDao dao=new StudentDao();
			Student student = dao.getStudentBySrn(srn,userName);

			if(student != null){
			    request.setAttribute("student", student);
			}
			else{
			    request.setAttribute("msg",
			            "Student not found");
			}

			request.getRequestDispatcher("SearchStudent.jsp")
			       .forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

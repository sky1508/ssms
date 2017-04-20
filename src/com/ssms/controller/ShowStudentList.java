package com.ssms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssms.dao.StudentDAO;
import com.ssms.entity.Student;
import com.ssms.util.LogPrinter;

/**
 * Servlet implementation class ShowStudentList
 */
@WebServlet("/Students")
public class ShowStudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		LogPrinter.printClassAndMethod();
		
		List<Student> studentList = StudentDAO.GetStudents();//new ArrayList<Student>();
		
		/*Student s = new Student();
			s.setId(2);
			s.setName("Jaydeep");
			s.setCity("Bengaluru");
			studentList.add(s);*/
		request.setAttribute("studentList", studentList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Students.jsp");
		rd.forward(request, response);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

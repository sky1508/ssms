package com.ssms.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssms.dao.StudentDAO;
import com.ssms.entity.Student;
import com.ssms.util.LogPrinter;

import sun.util.logging.resources.logging_pt_BR;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyStudent")
public class ModifyStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStudent() {
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
		
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("Student id: "+id);
		
		Student student = new Student();
		student.setId(id);
		student.setName(request.getParameter("name"));
		student.setCity(request.getParameter("city"));
		
		StudentDAO.updateStudent(student);
		
		response.setContentType("text/html");
		response.getWriter().write("Student with id " + id + " deleted successfully");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

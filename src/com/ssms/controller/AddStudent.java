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

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LogPrinter.printClassAndMethod();
		
		System.out.println("Add student servlet");
		
		Student student = new Student();
		student.setName(request.getParameter("name"));
		student.setCity(request.getParameter("city"));
		StudentDAO.AddStudent(student);
		System.out.println("Here");
		response.setContentType("text/html");
		response.getWriter().write("Student Added");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

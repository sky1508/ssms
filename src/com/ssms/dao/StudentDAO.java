package com.ssms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssms.entity.Student;
import com.ssms.util.HibernateUtil;
import com.ssms.util.LogPrinter;

public class StudentDAO {
	public static void AddStudent(Student student){
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        
        session.save(student);
        session.getTransaction().commit();
        session.close();
	}
	
	public static List<Student> GetStudents() {
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        
        Query<Student> query = session.createQuery("from Student");        
        List<Student> students = query.list();
        
        session.getTransaction().commit();
        session.close();
		
		return students;
	}
}

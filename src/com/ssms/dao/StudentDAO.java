package com.ssms.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ssms.entity.Student;
import com.ssms.util.HibernateUtil;
import com.ssms.util.LogPrinter;

public class StudentDAO {
	public static void addStudent(Student student){
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        
        session.save(student);
        session.getTransaction().commit();
        session.close();
        
        return;
	}
	
	public static List<Student> getStudents() {
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        
        Query<Student> query = session.createQuery("from Student");        
        List<Student> students = query.list();
        
        session.getTransaction().commit();
        session.close();
		
		return students;
	}
	
	public static Student getStudentById(int id) {
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        
        
        Student student = session.get(Student.class, id);
        
        session.getTransaction().commit();
        session.close();
		
		return student;
	}
	
	public static void removeStudent(int id) {
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        

        Student toDelete = (Student) session.get(Student.class, id);
        session.delete(toDelete);
        
        session.getTransaction().commit();
        session.close();
		
		return;
	}
	
	public static void updateStudent(Student s) {
		LogPrinter.printClassAndMethod();
		
		Session session = HibernateUtil.getSessionFactory().openSession();        
        session.beginTransaction();        

        Student toUpdate = (Student) session.get(Student.class, s.getId());
        toUpdate.setName(s.getName());
        toUpdate.setCity(s.getCity());
        session.update(toUpdate);
        
        session.getTransaction().commit();
        session.close();
		
		return;
	}
}

package com.ssms.dao;

import org.hibernate.Session;

import com.ssms.util.HibernateUtil;
import com.ssms.entity.Student;
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
}

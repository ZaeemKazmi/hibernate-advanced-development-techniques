package com.zk.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zk.hibernate.demo.entity.Course;
import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();

			// get a course
			int theId = 10 ;
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("Deleting course: " + tempCourse);
			
			// delete course
			session.delete(tempCourse);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			session.close();
			factory.close();
			System.out.println("Factory closed");
		}
	}

}

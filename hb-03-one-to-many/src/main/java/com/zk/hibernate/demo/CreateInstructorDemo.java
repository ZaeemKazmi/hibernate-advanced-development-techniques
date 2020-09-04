package com.zk.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zk.hibernate.demo.entity.Course;
import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			// create the objects
			Instructor tempInstructor = new Instructor("Susan", "Public", "susan.public@zk.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://zk.com/youtube", "Video Games");
			
			// associate the objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			// save the instructor
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
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

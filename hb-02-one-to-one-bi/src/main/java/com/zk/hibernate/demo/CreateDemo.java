package com.zk.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
		
		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
			Instructor tempInstructor = new Instructor("Zaeem", "Kazmi", "zaeem@luv2code.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://luv2code.com/youtube", "Luv 2 code!!!");
			
//			Instructor tempInstructor = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Piano");

			
			// associate the objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note : this will ALSO save the details object because of the CascadeType.ALL
			//			
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
		} finally {
			factory.close();
			System.out.println("Factory closed");
		}
	}

}

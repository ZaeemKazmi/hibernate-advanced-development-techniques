package com.zk.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zk.hibernate.demo.entity.Course;
import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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

			// get the instructor from the db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			
			// create some courses
			Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			
			// add courses to instructor
			tempInstructor.addCourse(tempCourse1);
			tempInstructor.addCourse(tempCourse2);
			
			// save the courses
			System.out.println("Saving course: " + tempCourse1);
			System.out.println("Saving course: " + tempCourse2);
			session.save(tempCourse1);
			session.save(tempCourse2);
			
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

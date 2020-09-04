 package com.zk.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.Student;

public class CreateUserStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the objects
			Student tempStudent = new Student("Joe", "Doe", "jon.doe@gmail.com", "Hibernat");
			Instructor tempInstructor = new Instructor("Donald", "Duck", "donnie@gmail.com", 60000.00);
			
			// start a transaction
			session.beginTransaction();

			// save the created object
			System.out.println("Saving the student...");
			session.persist(tempStudent);
			session.persist(tempInstructor);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			// close session and factory (clean up code)
			session.close();
			factory.close();
		}
	}
}

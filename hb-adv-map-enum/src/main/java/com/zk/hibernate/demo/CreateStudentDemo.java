package com.zk.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zk.hibernate.demo.entity.Status;
import com.zk.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent1 = new Student("Joe", "Doe", "jon.doe@gmail.com", Status.ACTIVE);
			Student tempStudent2 = new Student("Donald", "Duck", "donnie@gmail.com", Status.INACTIVE);
			

			// start a transaction
			session.beginTransaction();

			// save the created object
			System.out.println("Saving the student...");
			session.persist(tempStudent1);
			session.persist(tempStudent2);

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

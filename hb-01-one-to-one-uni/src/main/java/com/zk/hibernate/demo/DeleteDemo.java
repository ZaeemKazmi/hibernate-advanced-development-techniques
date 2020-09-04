package com.zk.hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.zk.hibernate.demo.entity.Instructor;
import com.zk.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// Create session
		Session session = factory.getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("Deleting instructor: " + tempInstructor);

			// delete the instructor
			if (tempInstructor != null) {
				// Note : this will ALSO delete the details object because of the
				// CascadeType.ALL
				session.delete(tempInstructor);
			}
			// Commit transaction
			session.getTransaction().commit();

			System.out.println("Done");
		} finally {
			factory.close();
			System.out.println("Factory closed");
		}
	}

}

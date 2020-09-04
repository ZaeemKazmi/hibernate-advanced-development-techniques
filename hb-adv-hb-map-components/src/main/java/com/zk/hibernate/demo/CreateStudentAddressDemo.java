package com.zk.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zk.hibernate.demo.entity.Address;
import com.zk.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create the object
			Student tempStudent = new Student("Joe", "Doe", "jon.doe@gmail.com");
			
			// create address object
//			Address homeAddress = new Address("Some Street", "Some City", "12345");
			Address billingAddress = new Address("Some Billing Street", "Some Billing City", "XXXXX12345");

			// start a transaction
			session.beginTransaction();

			// save the created object
			System.out.println("Saving the student and images...");
//			tempStudent.setHomeAddress(homeAddress);
			tempStudent.setBillingAddress(billingAddress);
			session.persist(tempStudent);

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

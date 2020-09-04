package com.zk.hibernate.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "STUDENT") // optional otherwise default value would be class name i.e. Student
@Getter
@Setter
public class Student extends User {

	private String course;

	public Student(String firstName, String lastName, String email, String course) {
		super(firstName, lastName, email);
		this.course = course;
	}

}

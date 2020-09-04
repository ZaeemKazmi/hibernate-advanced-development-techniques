package com.zk.hibernate.demo.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue(value = "INSTRUCTOR") // optional otherwise default value would be class name i.e. Instructor
@Getter
@Setter
public class Instructor extends User {

	private Double salary;

	public Instructor(String firstName, String lastName, String email, Double salary) {
		super(firstName, lastName, email);
		this.salary = salary;
	}

}

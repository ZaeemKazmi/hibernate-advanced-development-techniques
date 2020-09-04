package com.zk.hibernate.demo.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "student")
@Data // has getter, setter and toString
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Embedded // optional, since we have made Address embeddable, so hibernate is smart enough
				// to recognize this as embedded object
	private Address homeAddress;

//	@Embedded
	@AttributeOverrides({ 
		@AttributeOverride(name = "street", column = @Column(name = "BILLING_STREET")),
		@AttributeOverride(name = "city", column = @Column(name = "BILLING_CITY")),
		@AttributeOverride(name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")) 
	})
	private Address billingAddress;

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

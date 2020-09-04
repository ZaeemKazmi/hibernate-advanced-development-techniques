package com.zk.hibernate.demo.entity;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
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

	@ElementCollection
 	@CollectionTable(name = "image") // default table name by hibernate would have been student_images
	// joinColumns = @JoinColumn(name = "student_id")) // implicit
	@MapKeyColumn(name = "file_name") // key
	@Column(name = "image_name") // value
	private Map<String, String> images = new HashMap<String, String>();

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

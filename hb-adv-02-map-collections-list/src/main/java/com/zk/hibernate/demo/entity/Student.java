package com.zk.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
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
	@OrderColumn // optional annotation which gives additional order column to persist the list
					// order of the elements,
	// column name implicitly would be image_ORDER , or custom column could be provided as well
	@Column(name = "file_name") // Column name provided otherwise hibernate will consider 'images' as the
								// default column name
	private List<String> images = new ArrayList<String>();

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

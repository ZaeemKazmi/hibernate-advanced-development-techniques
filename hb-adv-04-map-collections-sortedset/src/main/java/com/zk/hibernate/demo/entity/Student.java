package com.zk.hibernate.demo.entity;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data // has getter, setter and toString
@NoArgsConstructor	// important in this case
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
//	@OrderBy // only one possible order; file_name asc ... when using javax.persistence
//	@org.hibernate.annotations.OrderBy(clause = "file_name") // sort in ascending order by default
	@org.hibernate.annotations.OrderBy(clause = "file_name desc") // sort in descending order, desc can be replaced with asc
	@Column(name = "file_name") // Column name provided otherwise hibernate will consider 'images' as
								// the default column name
	private Set<String> images = new LinkedHashSet<String>();

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

}

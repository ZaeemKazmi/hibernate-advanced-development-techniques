package com.zk.hibernate.demo.entity;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.SortComparator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@Data // has getter, setter and toString
@NoArgsConstructor
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
//	@OrderBy // sorts inside the database in ascending order
	@SortComparator(ReverseStringComparator.class) // Using our custom sorting algo 
	private SortedMap<String, String> images = new TreeMap<String, String>();

	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	// for initializing our own custom in-memory descending sort
	public static class ReverseStringComparator implements Comparator<String> {
		
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	}

}

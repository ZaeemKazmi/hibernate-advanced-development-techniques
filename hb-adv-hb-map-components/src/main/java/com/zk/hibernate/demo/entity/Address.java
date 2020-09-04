package com.zk.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data // has getter, setter and toString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@Column(name="zipcode")
	private String zipcode;
	
}

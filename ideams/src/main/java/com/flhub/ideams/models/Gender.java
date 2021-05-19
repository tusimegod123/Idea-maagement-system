package com.flhub.ideams.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name="admin_lookup_gender")

public class Gender extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer genderId;
	
	public Gender(String genderName) {
		super();
		this.genderName = genderName;
	}

//	public Gender(String genderId, String genderName) {
//		super();
//		this.genderId = genderId;
//		this.genderName = genderName;
//	}
    
	public Gender() {
		
	}
	
	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

	@Column
	private String genderName;

}

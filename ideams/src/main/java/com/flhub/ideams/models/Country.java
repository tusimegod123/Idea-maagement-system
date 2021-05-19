package com.flhub.ideams.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@Entity
@EntityListeners(AuditingEntityListener.class)
@Table (name="admin_lookup_country")
public class Country extends Auditable<String> {
	@Id

   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryId;
	
	@Column 
	private String CountryName;

	public Country() {
		
	}
	
  
	
	public Integer getCountryId() {
		return countryId;
	}



	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}



	public String getCountryName() {
		return CountryName;
	}

	public void setCountryName(String countryName) {
		CountryName = countryName;
	}

	public Country(Integer countryId, String countryName) {
		super();
		this.countryId = countryId;
		CountryName = countryName;
	}

	}

	


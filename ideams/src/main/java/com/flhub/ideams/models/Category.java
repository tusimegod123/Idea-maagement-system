package com.flhub.ideams.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name="admin_lookup_category")
public class Category extends Auditable<String> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Integer category_id;
	
	private String category_name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER,mappedBy = "category")
	
	private Set<Idea> ideas;
	
	public Set<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	public Category(Integer category_id, String category_name) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
	}
	
	
	
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", Category_name=" + category_name + "]";
	}

	public Category() {
		
	}

}

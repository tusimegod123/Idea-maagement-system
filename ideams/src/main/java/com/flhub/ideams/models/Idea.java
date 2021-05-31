package com.flhub.ideams.models;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@DynamicUpdate
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "ideaTable")
public class Idea extends Auditable<String> {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(updatable = false)
	private String ideaId;

	// @JsonIgnore
	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_id", insertable = false, updatable = false)
	// private User user;

	// private Long user_id;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;

	private Integer category_id;

	@OneToMany(fetch = FetchType.LAZY,  cascade =  CascadeType.ALL,
		mappedBy = "idea")
		private List<Note> notes = new ArrayList<Note>();
	// private Note note;

//	@Column(name = "createdDate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private LocalDateTime createdDate;

//	@Column
//	private String createdBy;
//
//	@Column
//	private String modifiedBy;

	@Column
	private String ideaTitle;

	@Column
//	@Temporal(TemporalType.DATE)

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private java.util.Date dateOfSubmission;

	@Column
	private String ideaDescription;

//	 @Column
	// @Temporal(TemporalType.DATE)
//	 @JsonFormat(pattern="yyyy-MM-dd")
//	 private Date createdDate;

//	@Column
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDateTime modifiedDate;

	@Column
	private String tenantId;

	@Column
	private String modifiedReason;

	@Column
	private String priorityId;

	@Column
	private String ideaStatus;

	@Column
	private String ideaApproveStatus;

	@Column
	private String ideaBackgroundDescription;


	

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	@Column
	private String document;

	@Column
	private Long size;

	public Idea(String ideaId, User user, Long user_id, Category category, Integer category_id, String ideaTitle,
			java.util.Date dateOfSubmission, String ideaDescription, String tenantId, String modifiedReason,
			String priorityId, String ideaStatus, String ideaApproveStatus, String ideaBackgroundDescription,
			String document, Long size) {
		super();
		this.ideaId = ideaId;
		// this.user = user;
		// this.user_id = user_id;
		this.category = category;
		this.category_id = category_id;
//		this.createdDate = createdDate;
//		this.createdBy = createdBy;
//		this.modifiedBy = modifiedBy;
		this.ideaTitle = ideaTitle;
		this.dateOfSubmission = dateOfSubmission;
		this.ideaDescription = ideaDescription;
		// this.modifiedDate = modifiedDate;
		this.tenantId = tenantId;
		this.modifiedReason = modifiedReason;
		this.priorityId = priorityId;
		this.ideaStatus = ideaStatus;
		this.ideaApproveStatus = ideaApproveStatus;
		this.ideaBackgroundDescription = ideaBackgroundDescription;
		this.document = document;
		this.size = size;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public void setCreated_by(String created_by) {
//		this.createdBy = created_by;
//	}

//	@ManyToOne
//	private User users;

	public Idea() {

	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(String ideaId) {
		this.ideaId = ideaId;
	}

//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}

	public String getIdeaTitle() {
		return ideaTitle;
	}

	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}

	public java.util.Date getDateOfSubmission() {
		return dateOfSubmission;
	}

	public void setDateOfSubmission(java.util.Date dateOfSubmission) {
		this.dateOfSubmission = dateOfSubmission;
	}

	public String getIdeaDescription() {
		return ideaDescription;
	}

	public void setIdeaDescription(String ideaDescription) {
		this.ideaDescription = ideaDescription;
	}

//	public LocalDateTime getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(LocalDateTime createdDate) {
//		this.createdDate = createdDate;
//	}

//	public LocalDateTime getModifiedDate() {
//		return modifiedDate;
//	}

//	public void setModifiedDate(LocalDateTime modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getModifiedReason() {
		return modifiedReason;
	}

	public void setModifiedReason(String modifiedReason) {
		this.modifiedReason = modifiedReason;
	}

	public String getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(String priorityId) {
		this.priorityId = priorityId;
	}

	public String getIdeaStatus() {
		return ideaStatus;
	}

	public void setIdeaStatus(String ideaStatus) {
		this.ideaStatus = ideaStatus;
	}

	public String getIdeaApproveStatus() {
		return ideaApproveStatus;
	}

	public void setIdeaApproveStatus(String ideaApproveStatus) {
		this.ideaApproveStatus = ideaApproveStatus;
	}

	public String getIdeaBackgroundDescription() {
		return ideaBackgroundDescription;
	}

	public void setIdeaBackgroundDescription(String ideaBackgroundDescription) {
		this.ideaBackgroundDescription = ideaBackgroundDescription;
	}

	// public User getUser() {
	// 	return user;
	// }

	// public void setUser(User user) {
	// 	this.user = user;
	// }

	// public Long getUser_id() {
	// 	return user_id;
	// }

	// public void setUser_id(Long user_id) {
	// 	this.user_id = user_id;
	// }

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

}

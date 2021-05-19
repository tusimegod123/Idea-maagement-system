package com.flhub.ideams.models;

import java.sql.Date;
import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;


 
@Entity
@DynamicUpdate
@EntityListeners(AuditingEntityListener.class)
@Table(name = "users")
public class User extends Auditable<String> {
 
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    private String username;
    private String password;
    private boolean enabled;
    
//    @Column
//	private String userId;

	@Column
	private String firstName;

	@Column
	private String middleName;

	@Column
	private String lastName;

	@Column
	private String otherName;

	@Column
	private String fullName;

	@Column
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dateOfBirth;

	@Column
	private String nin;

	@Column
	private String primaryPhone;

	@Column
	private String secondaryPhone;

	@Column
	private String primaryEmail;

	@Column
	private String secondaryEmail;

	@Column
	private String preferredWhatsappNumber;

//	@Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private Date createdDate;

	@Column
	private String cardNumber;

//	@Column
//	private String modifiedByGlobalUserId;

	@Column
	private String tenantId;
	
	@Column
	private String postfixId;

	@Column
	private String genderId;

	@Column
	private String statusId;

	public User(Long id, String username, String password, boolean enabled, String firstName, String middleName,
			String lastName, String otherName, String fullName, Date dateOfBirth, String nin, String primaryPhone,
			String secondaryPhone, String primaryEmail, String secondaryEmail, String preferredWhatsappNumber,
			String cardNumber, String tenantId, String postfixId, String genderId, String statusId, String country,
			String modifiedReason, Set<Role> roles, Set<Idea> ideas) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.otherName = otherName;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.nin = nin;
		this.primaryPhone = primaryPhone;
		this.secondaryPhone = secondaryPhone;
		this.primaryEmail = primaryEmail;
		this.secondaryEmail = secondaryEmail;
		this.preferredWhatsappNumber = preferredWhatsappNumber;
		this.cardNumber = cardNumber;
		this.tenantId = tenantId;
		this.postfixId = postfixId;
		this.genderId = genderId;
		this.statusId = statusId;
		this.country = country;
		this.modifiedReason = modifiedReason;
		this.roles = roles;
		this.ideas = ideas;
	}

	@Column
	private String country;

	@Column
	private String modifiedReason;

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
            )
    private Set<Role> roles = new HashSet<>();
 
	
	
	@OneToMany (mappedBy = "user")
	
	private Set<Idea> ideas;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNin() {
		return nin;
	}

	public void setNin(String nin) {
		this.nin = nin;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getPrimaryEmail() {
		return primaryEmail;
	}

	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public String getPreferredWhatsappNumber() {
		return preferredWhatsappNumber;
	}

	public void setPreferredWhatsappNumber(String preferredWhatsappNumber) {
		this.preferredWhatsappNumber = preferredWhatsappNumber;
	}

//	public Date getCreatedDate() {
//		return createdDate;
//	}

//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getPostfixId() {
		return postfixId;
	}

	public void setPostfixId(String postfixId) {
		this.postfixId = postfixId;
	}

	public String getGenderId() {
		return genderId;
	}

	public void setGenderId(String genderId) {
		this.genderId = genderId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getModifiedReason() {
		return modifiedReason;
	}

	public void setModifiedReason(String modifiedReason) {
		this.modifiedReason = modifiedReason;
	}

	public Set<Idea> getIdeas() {
		return ideas;
	}

	public void setIdeas(Set<Idea> ideas) {
		this.ideas = ideas;
	}

    public void setId(Long id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	
    public Long getId() {
        return id;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	// public User(Long id, String username, String password, boolean enabled, String firstName, String middleName,
	// 		String lastName, String otherName, String fullName, Date dateOfBirth, String nin, String primaryPhone,
	// 		String secondaryPhone, String primaryEmail, String secondaryEmail, String preferredWhatsappNumber,
	// 		Date createdDate, String cardNumber, String tenantId, String postfixId, String genderId, String statusId,
	// 		String country, String modifiedReason, Set<com.flhub.ideams.models.Role> roles,
	// 		Set<com.flhub.ideams.models.Idea> ideas) {
	// 	super();
	// 	this.id = id;
	// 	this.username = username;
	// 	this.password = password;
	// 	this.enabled = enabled;
	// 	this.firstName = firstName;
	// 	this.middleName = middleName;
	// 	this.lastName = lastName;
	// 	this.otherName = otherName;
	// 	this.fullName = fullName;
	// 	this.dateOfBirth = dateOfBirth;
	// 	this.nin = nin;
	// 	this.primaryPhone = primaryPhone;
	// 	this.secondaryPhone = secondaryPhone;
	// 	this.primaryEmail = primaryEmail;
	// 	this.secondaryEmail = secondaryEmail;
	// 	this.preferredWhatsappNumber = preferredWhatsappNumber;
	// //	this.createdDate = createdDate;
	// 	this.cardNumber = cardNumber;
	// 	this.tenantId = tenantId;
	// 	this.postfixId = postfixId;
	// 	this.genderId = genderId;
	// 	this.statusId = statusId;
	// 	this.country = country;
	// 	this.modifiedReason = modifiedReason;
	// 	this.roles = roles;
	// 	this.ideas = ideas;
	// }
 
	public User() {
		
	}
	
    // remaining getters and setters are not shown for brevity
}

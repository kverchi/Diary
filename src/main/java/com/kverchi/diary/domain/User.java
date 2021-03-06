package com.kverchi.diary.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable {
	@Id
	//@SequenceGenerator(name="users_user_id_seq")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	private String username;
    private String password;
    private boolean enabled;
    private String email;
	private String information;
	@Column(name = "registration_date", insertable=false)
	private ZonedDateTime registrationDate;


	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
    		name="user_roles",
    		joinColumns = {@JoinColumn(name="user_id", referencedColumnName="user_id")},
    		inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="role_id")}
    		)
    private Collection<Role> roles = new HashSet<Role>();
    public User() {}
	public User(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public ZonedDateTime getRegistrationDate() {
		DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
		String text = registrationDate.format(formatter);
		registrationDate = ZonedDateTime.parse(text, formatter);
		return registrationDate;
	}

	public void setRegistrationDate(ZonedDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    
}

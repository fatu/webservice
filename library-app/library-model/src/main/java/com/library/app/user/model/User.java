package com.library.app.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@Table(name = "lib_user")
public abstract class User implements Serializable {
	private static final long serialVersionUID = 1050881026659874901L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", updatable = false)
	private Date createdAt;

	@NotNull
	@Size(min = 3, max = 40)
	private String name;

	@Email
	@NotNull
	@Column(unique = true)
	@Size(max = 70)
	private String email;

	@NotNull
	private String password;

	public enum Roles {
		CUSTOMER, EMPLOYEE, ADMINISTRATOR
	}

	@CollectionTable(name = "lib_user_role", joinColumns = @JoinColumn(name = "user_id"),
			uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "role" }))
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private List<Roles> roles;

	public enum UserType {
		CUSTOMER, EMPLOYEE
	}

	@Column(name = "type", insertable = false, updatable = false)
	@Enumerated(EnumType.STRING)
	private UserType userType;

	protected abstract List<Roles> getDefaultRoles();

	public User() {
		this.createdAt = new Date();
		this.roles = getDefaultRoles();
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(final List<Roles> roles) {
		this.roles = roles;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(final UserType userType) {
		this.userType = userType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", createdAt=" + createdAt + ", name=" + name + ", email=" + email + ", userType="
				+ userType + "]";
	}

}
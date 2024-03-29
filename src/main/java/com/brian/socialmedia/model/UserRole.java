package com.brian.socialmedia.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole implements Serializable {

	private static final long serialVersionUID = 98516951961L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userRoleId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private AppUser appUser;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	public UserRole() {
	}

	public UserRole(long userRoleId, AppUser appUser, Role role) {
		this.userRoleId = userRoleId;
		this.appUser = appUser;
		this.role = role;
	}

	public UserRole(AppUser appUser, Role role) {
		this.appUser = appUser;
		this.role = role;
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}

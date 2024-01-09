package com.brian.socialmedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brian.socialmedia.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {

	public Role findRoleByName(String name);

}

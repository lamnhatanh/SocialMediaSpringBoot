package com.brian.socialmedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brian.socialmedia.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

	public Role findRoleByName(String name);

}

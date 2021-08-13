package com.mock.project.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByroleName(String name);
	
}

package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findById(long id);
	Role findByRole(String role);
}



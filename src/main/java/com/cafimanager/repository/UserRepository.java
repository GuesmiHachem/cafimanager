package com.cafimanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cafimanager.model.Role;
import com.cafimanager.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(long id);
	User findByEmail(String email);
	List<User> findByRole(Role role);
}



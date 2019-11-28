package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Client;
import com.cafimanager.model.User;
import com.cafimanager.model.Ville;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findById(long id);
}



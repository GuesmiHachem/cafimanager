package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Client;
import com.cafimanager.model.Ville;


@Repository
public interface CafeRepository extends JpaRepository<Client, Long> {

	Client findById(long id);
}



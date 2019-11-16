package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Delegation;


@Repository
public interface DelegationRepository extends JpaRepository<Delegation, Long> {
	Delegation findById(long id);
}



package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Governorat;


@Repository
public interface GovernoratRepository extends JpaRepository<Governorat, Long> {

	Governorat findById(long id);
}



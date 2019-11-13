package com.cafimanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Ville;


@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

	Ville findById(long id);
}



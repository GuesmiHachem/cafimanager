package com.cafimanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.Delegation;
import com.cafimanager.model.Governorat;
import com.cafimanager.model.Ville;


@Repository
public interface VilleRepository extends JpaRepository<Ville, Long> {

	Ville findById(long id);
	Ville findByLibell(String libell);
	void  deleteById(long id);
	void  deleteByLibell(String libell);
	@Query("select v from Ville v where v.libell like %?1%")
	List<Ville> findAllByLibell(String libell); 
	
	
}



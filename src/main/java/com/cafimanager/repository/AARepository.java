package com.cafimanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cafimanager.model.AA;
import com.cafimanager.model.Cafe;
import com.cafimanager.model.User;


@Repository
public interface AARepository extends JpaRepository<AA, Long> {
	AA findById(long id);
	
}



package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer>{
	
	Grade findBygradeID(int id);
}

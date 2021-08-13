package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Year;

public interface YearRepository extends JpaRepository<Year, Integer>{
	Year findByyear(int year);
}

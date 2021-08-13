package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock.project.entity.start_year;

@Repository
public interface start_yearReponsitory extends JpaRepository<start_year, Integer> {
	start_year findBystartYear(int startYear);
}

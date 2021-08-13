package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Period;

public interface PeriodRepository extends JpaRepository<Period, Integer>{

}

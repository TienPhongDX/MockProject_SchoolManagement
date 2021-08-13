package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.project.entity.Day;

public interface DayRepository extends JpaRepository<Day, Integer>{

}

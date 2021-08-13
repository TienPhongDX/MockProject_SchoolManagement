package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.start_year;
import com.mock.project.repository.start_yearReponsitory;

@Service
public class start_yearServiceImpl implements start_yearService{
	
	@Autowired
	start_yearReponsitory startYearRepository;
	
	@Override
	public List<start_year> findAll() {
		return startYearRepository.findAll();
	}
}

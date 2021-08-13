package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Period;
import com.mock.project.repository.PeriodRepository;

@Service
public class PeriodServiceImpl implements PeriodService{
	
	@Autowired
	PeriodRepository periodRepository;
	
	@Override
	public List<Period> findAll() {
		return periodRepository.findAll();
	}

}

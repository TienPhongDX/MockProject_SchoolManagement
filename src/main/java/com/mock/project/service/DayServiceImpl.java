package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Day;
import com.mock.project.repository.DayRepository;

@Service
public class DayServiceImpl implements DayService{

	@Autowired
	DayRepository dayRepository;
	
	@Override
	public List<Day> findAll() {
		return dayRepository.findAll();
	}

}

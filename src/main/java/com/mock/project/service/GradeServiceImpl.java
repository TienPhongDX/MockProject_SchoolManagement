package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Grade;
import com.mock.project.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Override
	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}
}

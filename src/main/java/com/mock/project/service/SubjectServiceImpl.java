package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Subject;
import com.mock.project.repository.SubjectRepository;
@Service
public class SubjectServiceImpl implements SubjectService {
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Override
	public List<Subject> findAll() {
		return subjectRepository.findAll();
	}

	@Override
	public Subject findOne(int id) {
		return subjectRepository.getOne(id);
	}
}

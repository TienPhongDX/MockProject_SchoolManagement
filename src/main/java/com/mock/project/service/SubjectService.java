package com.mock.project.service;

import java.util.List;

import com.mock.project.entity.Subject;

public interface SubjectService {
	List<Subject> findAll();
	
	Subject findOne(int id);
}

package com.mock.project.service;

import java.util.List;

import com.mock.project.dto.NewStudentDTO;
import com.mock.project.entity.Student;

public interface StudentService {
	Iterable<Student> findAll();

	List<Student> search(String q);

	Student getOne(long id);

	void save(Student student);

	void delete(Student student);
	
	void insert_student(NewStudentDTO studentDTO);
	
	List<Student> sortStudents(int classID);
}

package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mock.project.dto.NewStudentDTO;
import com.mock.project.entity.Student;
import com.mock.project.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public List<Student> search(String a) {
		return studentRepository.findByNameLike(a);
	}

	@Override
	public Student getOne(long id) {

		return studentRepository.getOne(id);
	}

	@Override
	public void save(Student student) {

		studentRepository.save(student);
	}

	@Override
	public void delete(Student student) {
		studentRepository.delete(student);

	}

	@Override
	public void insert_student(NewStudentDTO studentDTO) {
		studentRepository.insert_teacher(studentDTO.getUsername(), passwordEncoder.encode(studentDTO.getPassword()), studentDTO.getName(), studentDTO.getBirthday(),
				studentDTO.getGender(), studentDTO.getAddress(), studentDTO.getPhone(), studentDTO.getClassStudying(), studentDTO.getPhoto());
	}

	@Override
	public List<Student> sortStudents(int classID) {
		return studentRepository.sortStudent(classID);
	}

}

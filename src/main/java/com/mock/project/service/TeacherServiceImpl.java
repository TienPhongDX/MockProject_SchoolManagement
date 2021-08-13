package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mock.project.dto.TeacherRegisterDTO;
import com.mock.project.entity.Teacher;
import com.mock.project.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Iterable<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher getOne(long id) {
		return teacherRepository.getOne(id);
	}

	@Override
	public void save(Teacher teacher) {
		teacherRepository.save(teacher);

	}

	@Override
	public void delete(Teacher teacher) {
		teacherRepository.delete(teacher);

	}


	@Override
	public void insert_teacher(TeacherRegisterDTO teacherDTO) {
		teacherRepository.insert_teacher(teacherDTO.getUsername(), passwordEncoder.encode(teacherDTO.getPassword()), teacherDTO.getName(),
				teacherDTO.getBirthday(), teacherDTO.getGender(), teacherDTO.getAddress(), teacherDTO.getPhone(),
				teacherDTO.getSubjectID(), teacherDTO.getSalary(), teacherDTO.getPhoto());
	}
	@Override
	public void delete_teacher(Teacher teacher) {
		teacherRepository.delete_teacher(teacher.getTeacherID());
	}
	
	@Override
	public List<Teacher> search(String q) {
		return teacherRepository.findByNameLike(q);
	}

}

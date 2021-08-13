package com.mock.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.entity.Class;
import com.mock.project.repository.ClassRepository;
import com.mock.project.repository.TimetableRepository;

@Service
public class ClassServiceImpl implements ClassService{
	@Autowired private ClassRepository classRepository;  	
	
	
	@Override  
	public void saveClass(Class newClass) {  
		classRepository.save(newClass);
	}
	
	@Override
	public Class findByNameAndYear(String name, int year) {
		return classRepository.findByClassNameAndStartYear(name, year);
	}
	
	@Override
	public List<Class> selectClass() {
		return classRepository.selectClass();
	}
	
	@Override
	public List<Class> findAllOrderByGradeID() {
		return classRepository.findAllByOrderByGradeIDAsc();
	}
	
	@Override
	public String findTeacherCnNameByClassID(int classID) {
		return classRepository.findTeacherCnNameByClassID(classID);
	}
	
	@Override
	public Class getOne(int classID) {
		return classRepository.getOne(classID);
	}

	@Override
	public List<Class> findStudiedClass(long studentID) {
		return classRepository.findStudiedClass(studentID);
	}

	@Override
	public List<Class> findClassTeaching(long teacherID) {
		return classRepository.findClassTeaching(teacherID);
	}
	@Override
	public Class findByClassID(int id) {
		return classRepository.findByClassID(id);
	}
	
	
	
	
}

package com.mock.project.service;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mock.project.entity.Class;

public interface ClassService {
	void saveClass(Class newClass);
	Class findByNameAndYear(String name, int year);
	List<Class> selectClass();
	List<Class> findAllOrderByGradeID();
	String findTeacherCnNameByClassID(int classID);
	Class getOne(int classID);
	List<Class> findStudiedClass(long studentID);
	List<Class> findClassTeaching(long teacherID);
	Class findByClassID(int id);
}

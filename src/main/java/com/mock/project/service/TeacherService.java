package com.mock.project.service;

import java.util.List;

import com.mock.project.dto.TeacherRegisterDTO;
import com.mock.project.entity.Teacher;

public interface TeacherService {
	Iterable<Teacher> findAll();

    List<Teacher> search(String q);

    Teacher getOne(long id);

    void save(Teacher teacher);

    void delete(Teacher teacher);
    
    void delete_teacher(Teacher teacher);
    
    void insert_teacher(TeacherRegisterDTO teacherDTO);
}

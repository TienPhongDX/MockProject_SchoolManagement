package com.mock.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock.project.entity.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
		Subject findBysubjectName(String name);
}

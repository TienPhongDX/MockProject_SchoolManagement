package com.mock.project.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mock.project.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	List<Teacher> findByNameContaining(String q);
	List<Teacher> findByNameLike(String q);
	@Transactional
	@Modifying
	@Query(value = "exec insert_teacher :param1, :param2, :param3, :param4, :param5, :param6, :param7, :param8, :param9, :param10 ", nativeQuery = true)
	void insert_teacher(
			@Param("param1") String param1, 
			@Param("param2") String param2,
			@Param("param3") String param3,
			@Param("param4") Date param4,
			@Param("param5") String param5,
			@Param("param6") String param6,
			@Param("param7") String param7,
			@Param("param8") int param8,
			@Param("param9") float param9,
			@Param("param10") String param10
			);
	@Transactional
	@Modifying
	@Query(value = "exec delete_teacher :param1", nativeQuery = true)
	void delete_teacher(
			@Param("param1") long param1
			);
	
}

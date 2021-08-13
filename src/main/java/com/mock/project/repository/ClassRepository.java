package com.mock.project.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mock.project.entity.Class;

@Repository 
public interface ClassRepository extends JpaRepository<Class, Integer>{
	Class findByClassNameAndStartYear(String name, int year);
	Class findByClassID(int id);
	
	List<Class> findAllByOrderByGradeIDAsc();
	
	@Transactional
	@Query(value = "select * from Class where start_year = (select top 1 * from start_year) order by gradeID", nativeQuery = true)
	List<Class> selectClass();
	
	@Transactional
	@Query(value = "select Teacher.name from Teacher inner join Class on Teacher.teacherID = Class.teachercnID where classID = :param1", nativeQuery = true)
	String findTeacherCnNameByClassID(@Param("param1") int param1);
	
	@Transactional
	@Query(value = "select * from Class where classID in (select Mark.classID from Mark group by Mark.classID, Mark.studentID having Mark.studentID = :param1)",
	nativeQuery = true)
	List<Class> findStudiedClass(@Param("param1") long param1);
	
	@Transactional
	@Query(value = "select * from Class where Class.classID in (select Timetable.classID from Timetable inner join Class on Timetable.classID = Class.classID "
			+ "group by Timetable.classID, Timetable.teacherID, Class.start_year having Timetable.teacherID = :param1 and Class.start_year = (select top 1 * from start_year))",
			nativeQuery = true)
	List<Class> findClassTeaching(@Param("param1") long param1);
}

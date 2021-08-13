package com.mock.project.repository;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mock.project.entity.Mark;

public interface MarkRepository extends JpaRepository<Mark, Integer>{

	@Transactional
	@Query(value="select [Subject].subject_name, M1.hs1 as hs1k1, M1.hs2 as hs2k1, M1.hs3 as hs3k1, M1.total as totalk1, M2.hs1 as hs1k2, M2.hs2 as hs2k2, M2.hs3 as hs3k2, M2.total as totalk2, (M1.total + M2.total*2)/3 as [avg], Report.result "
			+ "from Mark M1 inner join Mark M2 on M1.subjectID = M2.subjectID inner join Report on M2.studentID = Report.studentID and M2.classID = Report.classID inner join [Subject] on [Subject].subjectID = M2.subjectID "
			+ "where M1.studentID = :param1 and M2.studentID = :param1 and M1.classID = :param2 and M2.classID = :param2 and M1.semester = 1 and M2.semester = 2",
			nativeQuery = true)
	Iterable<Object[]> viewMark(
			@Param("param1") Long param1,
			@Param("param2") Integer param2);
	
	@Transactional
	@Query(value="select Student.name, Student.birthday, M1.hs1 as hs1k1, M1.hs2 as hs2k1, M1.hs3 as hs3k1, M1.total as totalk1, M2.hs1 as hs1k2, M2.hs2 as hs2k2, M2.hs3 as hs3k2, M2.total as totalk2, (M1.total + M2.total*2)/3 as [avg], Report.result, [Subject].subject_name, Student.class_studying, Student.studentID "
			+ "from Mark M1 inner join Mark M2 on M1.subjectID = M2.subjectID and M1.studentID = M2.studentID inner join Report on M2.studentID = Report.studentID and M2.classID = Report.classID inner join Student on Student.studentID = M2.studentID inner join [Subject] on [Subject].subjectID = M2.subjectID "
			+ "group by Student.name, Student.birthday, M1.hs1, M1.hs2, M1.hs3, M1.total, M2.hs1, M2.hs2, M2.hs3, M2.total, Report.result, [Subject].subject_name, Student.class_studying, M1.semester, M2.semester, [Subject].subjectID, Student.studentID "
			+ "having M1.semester = 1 and M2.semester = 2 and Student.class_studying = :param1 and [Subject].subjectID = :param2",
			nativeQuery = true)
	Iterable<Object[]> viewMarkBySubject(
			@Param("param1") Integer param1,
			@Param("param2") Integer param2);
	
	@Transactional
	@Modifying
	@Query(value = "exec edit_mark :param1, :param2, :param3, :param4, :param5, :param6, :param7, :param8, :param9", nativeQuery = true)
	void edit_mark(
			@Param("param1") int param1, 
			@Param("param2") int param2,
			@Param("param3") int param3,
			@Param("param4") double param4,
			@Param("param5") double param5,
			@Param("param6") double param6,
			@Param("param7") double param7,
			@Param("param8") double param8,
			@Param("param9") double param9
			);
}

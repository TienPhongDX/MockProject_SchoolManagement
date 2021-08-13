package com.mock.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mock.project.entity.Timetable;

public interface TimetableRepository extends JpaRepository<Timetable, Long>{
	@Transactional
	@Query(value = "select NewTable2.periodID, NewTable2.dayID, Teacher.name, [Subject].subject_name, NewTable2.classID "
			+ "from NewTable2 full join Timetable "
			+ "on Timetable.periodID = NewTable2.periodID and Timetable.dayID = NewTable2.dayID and Timetable.classID = NewTable2.classID "
			+ "full join Teacher on Teacher.teacherID = Timetable.teacherID "
			+ "full join [Subject] on [Subject].subjectID = Teacher.subjectID "
			+ "group by NewTable2.periodID, NewTable2.dayID, Teacher.name, [Subject].subject_name, NewTable2.classID "
			+ "having NewTable2.classID = :param1",
			nativeQuery = true)
	Iterable<Object[]> viewTimetable(@Param("param1") Integer param1);
	
	@Transactional
	@Modifying
	@Query(value = "insert into Timetable(classID, dayID, periodID, teacherID) values (:param1, :param2, :param3, :param4)",
			nativeQuery = true)
	void addTimetable(
			@Param("param1") int param1,
			@Param("param2") int param2,
			@Param("param3") int param3,
			@Param("param4") int param4);
	
	@Transactional
	@Modifying
	@Query(value = "delete from Timetable where classID = :param1 and periodID = :param2 and dayID = :param3",
			nativeQuery = true)
	void deleteTimetable(
			@Param("param1") int param1,
			@Param("param2") int param2,
			@Param("param3") int param3);
	
	@Transactional
	@Modifying
	@Query(value="drop table NewTable2\r\n"
			+ "select Period.periodID, [Day].dayID, Class.classID into NewTable2 from Period, [Day], Class", nativeQuery = true)
	void newTable2();
	
	@Transactional
	@Modifying
	@Query(value="drop table NewTable3\r\n"
			+ "select Period.periodID, [Day].dayID, Teacher.teacherID, start_year.start_year into NewTable3 from Period, [Day], Teacher, start_year"
			, nativeQuery = true)
	void newTable3();
	
	@Transactional
	@Query(value = "select NewTable3.periodID, NewTable3.dayID, Class.class_name, NewTable3.teacherID, NewTable3.start_year "
			+ "from NewTable3 full join Timetable "
			+ "on Timetable.periodID = NewTable3.periodID and Timetable.dayID = NewTable3.dayID and Timetable.teacherID = NewTable3.teacherID "
			+ "full join Class on Class.classID = Timetable.classID "
			+ "full join start_year on start_year.start_year = Class.start_year "
			+ "group by NewTable3.periodID, NewTable3.dayID, Class.class_name, start_year.start_year, NewTable3.teacherID, NewTable3.start_year "
			+ "having NewTable3.teacherID = :param1 and NewTable3.start_year = (select top 1 * from start_year)",
			nativeQuery = true)
	Iterable<Object[]> viewSchedule(
			@Param("param1") long teacherID);
}

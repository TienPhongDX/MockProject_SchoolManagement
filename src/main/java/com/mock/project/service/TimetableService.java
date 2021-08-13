package com.mock.project.service;

import com.mock.project.dto.ViewSchedule;
import com.mock.project.dto.ViewTimetable;
import com.mock.project.entity.Timetable;

public interface TimetableService {
	Iterable<ViewTimetable> viewTimetable(Integer classID);
	
	void saveTimetable(Timetable timetable);
	
	void addTimetable(int classID, int dayID, int periodID, int teacherID);
	
	void deleteTimetable(int classID, int periodID, int dayID);
	
	void newTable2();
	
	void newTable3();
	
	Iterable<ViewSchedule> viewSchedule(long teacherID);
}

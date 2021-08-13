package com.mock.project.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dto.ViewSchedule;
import com.mock.project.dto.ViewTimetable;
import com.mock.project.entity.Timetable;
import com.mock.project.repository.TimetableRepository;

@Service
public class TimetableServiceImpl implements TimetableService{
	
	@Autowired
	private TimetableRepository timetableRepository;
	
	@Override
	public Iterable<ViewTimetable> viewTimetable(Integer classID) {
		Iterable<Object[]> datas=  timetableRepository.viewTimetable(classID);
		ArrayList<ViewTimetable> result = new ArrayList<ViewTimetable>();
		datas.forEach(item -> {
			ViewTimetable obj = new ViewTimetable();
			obj.setPeriodID(item[0]==null ? null : ((Integer)item[0]).longValue());
			obj.setDayID(item[1]==null ? null : ((Integer)item[1]).longValue());
			obj.setName((String)item[2]);
			obj.setSubjectName((String)item[3]);
			obj.setClassID(item[4]==null ? null : ((Integer)item[4]).longValue());
			result.add(obj);
		});
		return result;
	}
	
	@Override
	public Iterable<ViewSchedule> viewSchedule(long teacherID) {
		Iterable<Object[]> datas=  timetableRepository.viewSchedule(teacherID);
		ArrayList<ViewSchedule> result = new ArrayList<ViewSchedule>();
		datas.forEach(item -> {
			ViewSchedule obj = new ViewSchedule();
			obj.setPeriodID(item[0]==null ? null : ((Integer)item[0]));
			obj.setDayID(item[1]==null ? null : ((Integer)item[1]));
			obj.setClassName((String)item[2]);
			obj.setTeacherID(item[3]==null ? null : ((Integer)item[3]));
			obj.setStartYear(item[4]==null ? null : ((Integer)item[4]));
			result.add(obj);
		});
		return result;
	}

	@Override
	public void saveTimetable(Timetable timetable) {
		timetableRepository.save(timetable);
	}

	@Override
	public void addTimetable(int classID, int dayID, int periodID, int teacherID) {
		timetableRepository.addTimetable(classID, dayID, periodID, teacherID);
	}

	@Override
	public void deleteTimetable(int classID, int periodID, int dayID) {
		timetableRepository.deleteTimetable(classID, periodID, dayID);
		
	}

	@Override
	public void newTable2() {
		timetableRepository.newTable2();
	}

	@Override
	public void newTable3() {
		timetableRepository.newTable3();
	}

}

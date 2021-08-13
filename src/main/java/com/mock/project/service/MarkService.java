package com.mock.project.service;

import com.mock.project.dto.ViewMark;
import com.mock.project.dto.ViewMarkBySubject;

public interface MarkService {
	Iterable<ViewMark> viewMark(long studentID, int classID);
	
	Iterable<ViewMarkBySubject> viewMarkBySubject(int classID, int subjectID);
	
	void edit_mark(int studentID, int subjectID, int classID, double hs1k1, double hs2k1, double hs3k1, double hs1k2, double hs2k2, double hs3k2);
	
	ViewMarkBySubject searchByStudentID(int studentID, int classID, int subjectID);
}

package com.mock.project.service;

import java.util.ArrayList;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.project.dto.ViewMark;
import com.mock.project.dto.ViewMarkBySubject;
import com.mock.project.repository.MarkRepository;

@Service
public class MarkServiceImpl implements MarkService{

	@Autowired
	private MarkRepository markRepository;
	
	@Override
	public Iterable<ViewMark> viewMark(long studentID, int classID) {
		Iterable<Object[]> datas=  markRepository.viewMark(studentID, classID);
		ArrayList<ViewMark> result = new ArrayList<ViewMark>();
		
		datas.forEach(item -> {
			ViewMark obj = new ViewMark();
			obj.setSubjectName((String)item[0]);;
			obj.setHs1k1(item[1]==null ? null : (Double)item[1]);
			obj.setHs2k1(item[2]==null ? null : (Double)item[2]);
			obj.setHs3k1(item[3]==null ? null : (Double)item[3]);
			obj.setTotalk1(item[4]==null ? null : (Double)item[4]);
			obj.setHs1k2(item[5]==null ? null : (Double)item[5]);
			obj.setHs2k2(item[6]==null ? null : (Double)item[6]);
			obj.setHs3k2(item[7]==null ? null : (Double)item[7]);
			obj.setTotalk2(item[8]==null ? null : (Double)item[8]);
			obj.setAvg(item[9]==null ? null : (Double)item[9]);
			obj.setResult((String)item[10]);
			
			result.add(obj);
		});
		
		return result;
	}

	@Override
	public Iterable<ViewMarkBySubject> viewMarkBySubject(int classID, int subjectID) {
		Iterable<Object[]> datas=  markRepository.viewMarkBySubject(classID, subjectID);
		ArrayList<ViewMarkBySubject> result = new ArrayList<ViewMarkBySubject>();
		datas.forEach(item -> {
			ViewMarkBySubject obj = new ViewMarkBySubject();
			obj.setStudentName((String)item[0]);;
			obj.setBirthday((Date)item[1]);
			obj.setHs1k1(item[2]==null ? null : (Double)item[2]);
			obj.setHs2k1(item[3]==null ? null : (Double)item[3]);
			obj.setHs3k1(item[4]==null ? null : (Double)item[4]);
			obj.setTotalk1(item[5]==null ? null : (Double)item[5]);
			obj.setHs1k2(item[6]==null ? null : (Double)item[6]);
			obj.setHs2k2(item[7]==null ? null : (Double)item[7]);
			obj.setHs3k2(item[8]==null ? null : (Double)item[8]);
			obj.setTotalk2(item[9]==null ? null : (Double)item[9]);
			obj.setAvg(item[10]==null ? null : (Double)item[10]);
			obj.setResult((String)item[11]);
			obj.setSubjectName((String)item[12]);
			obj.setClassID(item[13]==null ? null : (Integer)item[13]);
			obj.setStudentID(item[14]==null ? null : (Integer)item[14]);
			
			result.add(obj);
		});
		return result;
	}

	@Override
	public void edit_mark(int studentID, int subjectID, int classID, double hs1k1, double hs2k1, double hs3k1,
			double hs1k2, double hs2k2, double hs3k2) {
		markRepository.edit_mark(studentID, subjectID, classID, hs1k1, hs2k1, hs3k1, hs1k2, hs2k2, hs3k2);
	}

	@Override
	public ViewMarkBySubject searchByStudentID(int studentID, int classID, int subjectID) {
		Iterable<Object[]> datas = markRepository.viewMarkBySubject(classID, subjectID);
		ArrayList<ViewMarkBySubject> result = new ArrayList<ViewMarkBySubject>();
		datas.forEach(item -> {
			ViewMarkBySubject obj = new ViewMarkBySubject();
			obj.setStudentName((String)item[0]);;
			obj.setBirthday((Date)item[1]);
			obj.setHs1k1(item[2]==null ? null : (Double)item[2]);
			obj.setHs2k1(item[3]==null ? null : (Double)item[3]);
			obj.setHs3k1(item[4]==null ? null : (Double)item[4]);
			obj.setTotalk1(item[5]==null ? null : (Double)item[5]);
			obj.setHs1k2(item[6]==null ? null : (Double)item[6]);
			obj.setHs2k2(item[7]==null ? null : (Double)item[7]);
			obj.setHs3k2(item[8]==null ? null : (Double)item[8]);
			obj.setTotalk2(item[9]==null ? null : (Double)item[9]);
			obj.setAvg(item[10]==null ? null : (Double)item[10]);
			obj.setResult((String)item[11]);
			obj.setSubjectName((String)item[12]);
			obj.setClassID(item[13]==null ? null : (Integer)item[13]);
			obj.setStudentID(item[14]==null ? null : (Integer)item[14]);
			
			result.add(obj);
		});
		
		for (ViewMarkBySubject viewMarkBySubject : result) {
			if (viewMarkBySubject.getStudentID() == studentID) return viewMarkBySubject;
		}
		return null;
	}
}

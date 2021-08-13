package com.mock.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.dto.TeacherRegisterDTO;
import com.mock.project.dto.ViewMarkBySubject;
import com.mock.project.entity.Account;
import com.mock.project.entity.Student;
import com.mock.project.entity.Subject;
import com.mock.project.entity.Teacher;
import com.mock.project.service.AccountService;
import com.mock.project.service.ClassService;
import com.mock.project.service.MarkService;
import com.mock.project.service.StudentService;
import com.mock.project.service.SubjectService;
import com.mock.project.service.TeacherService;
import com.mock.project.service.TimetableService;

@Controller
public class MarkController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private MarkService markService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private TimetableService timetableService;
	
	@RequestMapping("/viewmark")
	public String viewMark(HttpServletRequest request,Model model) {
		try {
			Account account;
			String username = request.getUserPrincipal().getName();
			account = accountService.getOne(username);
			Student s = studentService.getOne(account.getAccountID());
			model.addAttribute("student", s);
			model.addAttribute("classes", classService.findStudiedClass(s.getStudentID()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "XemDiem";
	}
	
	@GetMapping("/chooseClass")
	public String chooseClass(@RequestParam("classID") Integer classID, Model model, HttpServletRequest request) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Student s = studentService.getOne(account.getAccountID());
		model.addAttribute("student", s);
		model.addAttribute("classes", classService.findStudiedClass(s.getStudentID()));
		model.addAttribute("marks", markService.viewMark(s.getStudentID(), classID));
		
		return "XemDiem";
	}
	
	@GetMapping("/managemarks")
	public String manageMarks(HttpServletRequest request, Model model) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Teacher t = teacherService.getOne(account.getAccountID());
		model.addAttribute("teacher", t);
		model.addAttribute("classes", classService.findClassTeaching(t.getTeacherID()));
		return "NhapDiem";
	}
	
	@GetMapping("/findClassMarks")
	public String findClassMarks(HttpServletRequest request, Model model, @RequestParam("classID") Integer classID) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Teacher t = teacherService.getOne(account.getAccountID());
		model.addAttribute("teacher", t);
		model.addAttribute("classes", classService.findClassTeaching(t.getTeacherID()));
		model.addAttribute("schedules", timetableService.viewSchedule(t.getTeacherID()));
		model.addAttribute("classID", classID);
		model.addAttribute("marks", markService.viewMarkBySubject(classID, t.getSubjectID()));
		return "NhapDiem";
	}
	
	@GetMapping("/mark/{studentID}/{classStudying}/edit")
	public String editMark(HttpServletRequest request, Model model, @PathVariable int classStudying, @PathVariable int studentID, RedirectAttributes redirect) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Teacher t = teacherService.getOne(account.getAccountID());
		model.addAttribute("teacher", t);
		model.addAttribute("classes", classService.findClassTeaching(t.getTeacherID()));
		model.addAttribute("schedules", timetableService.viewSchedule(t.getTeacherID()));
		model.addAttribute("classID", classStudying);
		model.addAttribute("marks", markService.viewMarkBySubject(classStudying, t.getSubjectID()));
		model.addAttribute("editMark", new ViewMarkBySubject());
		ViewMarkBySubject v = markService.searchByStudentID(studentID, classStudying, t.getSubjectID());
		//Subject s = subjectService.findOne(v.getStudentID());
		//model.addAttribute("editMarks", markService.edit_mark(v.getStudentID(), s.getSubjectID(), v.getClassID(), v.getHs1k1(), v.getHs2k1(), v.getHs3k1(), v.getHs1k2(), v.getHs2k2(), v.getHs3k2()));
		model.addAttribute("confirmedMarks", v);
		return "NhapDiem";
	}
	
	@RequestMapping("saveMarks")
	public String confirm(HttpServletRequest request, Model model, @RequestParam("studentID")Integer studentID, @RequestParam("classStudying")Integer classID,
			@RequestParam("hs1k1")Double hs1k1, @RequestParam("hs2k1")Double hs2k1, @RequestParam("hs3k1")Double hs3k1,
			@RequestParam("hs1k2")Double hs1k2, @RequestParam("hs2k2")Double hs2k2, @RequestParam("hs3k2")Double hs3k2) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Teacher t = teacherService.getOne(account.getAccountID());
		model.addAttribute("teacher", t);
		model.addAttribute("classes", classService.findClassTeaching(t.getTeacherID()));
		model.addAttribute("schedules", timetableService.viewSchedule(t.getTeacherID()));
		model.addAttribute("classID", classID);
		model.addAttribute("marks", markService.viewMarkBySubject(classID, t.getSubjectID()));
		
		System.out.println(hs1k1 + " - " + hs2k1);
		
		markService.edit_mark(studentID, t.getSubjectID(), classID, hs1k1, hs2k1, hs3k1, hs1k2, hs2k2, hs3k2);
		return "redirect:/findClassMarks?classID=" + classID;
	}
	/*
	@PostMapping("/account/change")
	public String changePass( @ModelAttribute("ChangePasswordDTO") ChangePasswordDTO changepassworddto, BindingResult result, 
			HttpServletRequest request,Model model) {
		try {
			Account account;
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String username = request.getUserPrincipal().getName();
			account = accountService.getOne(username);
			if (encoder.matches(changepassworddto.getPassword(), account.getPassword())) {
				account.setPassword(passwordEncoder.encode(changepassworddto.getNewpassword()));
				accountService.save(account);
				model.addAttribute("success", "Your password is updated"
						+ " successfully!");
			} else {
				model.addAttribute("invalid", "Your current password is not correct or empty string!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ChangePassword";
	}*/
}

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.entity.Account;
import com.mock.project.entity.Teacher;
import com.mock.project.entity.Timetable;
import com.mock.project.service.AccountService;
import com.mock.project.service.ClassService;
import com.mock.project.service.DayService;
import com.mock.project.service.MarkService;
import com.mock.project.service.PeriodService;
import com.mock.project.service.StudentService;
import com.mock.project.service.TeacherService;
import com.mock.project.service.TimetableService;

@Controller
public class TimetableController {
	Integer value = null;
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private DayService dayService;
	
	@Autowired
	private PeriodService periodService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private MarkService markService;
	
	@GetMapping("/viewtimetable")
	public String teacher(Model model) {
		return "XemThoiKhoaBieu";
	}
	
	@GetMapping("/searchClass")  
	public String searchClass(@RequestBody @RequestParam("classID") Integer classID, Model model)  
	{
		if(classService.findByClassID(classID)!= null) {
			model.addAttribute("timetables", timetableService.viewTimetable(classID));
			System.out.println(model);
		}else {
			return "redirect:/viewtimetable";
		}
	    return "XemThoiKhoaBieu";  
	}
	
	@GetMapping("/addtimetable")
	public String addTimetable(Model model) {
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("days", dayService.findAll());
		model.addAttribute("periods", periodService.findAll());
		return "ThemThoiKhoaBieu";
	}
	
	@GetMapping("/searchFirst")  
	public String searchFirst(@RequestParam("classID") Integer classID, Model model)  
	{
		/*if (classID != null) {*/
			model.addAttribute("currentClassID", classID);
			//value = classID;
		//}
		//else model.addAttribute("currentClassID", value);
		model.addAttribute("foundClass", classService.getOne(classID));
		model.addAttribute("timetables", timetableService.viewTimetable(classID));
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("days", dayService.findAll());
		model.addAttribute("periods", periodService.findAll());
		System.out.println(model);
	    return "ThemThoiKhoaBieu";  
	}
	
	@PostMapping("/newTimetable")
	public String save(@ModelAttribute("newTimetable") Timetable newTimetable, @RequestParam("classID") Integer classID,
			@RequestParam("dayID") Integer dayID, @RequestParam("periodID") Integer periodID, @RequestParam("teacherID") Integer teacherID,
			BindingResult bind, Model model) {
		model.addAttribute("currentClassID", classID);
		model.addAttribute("foundClass", classService.getOne(classID));
		model.addAttribute("timetables", timetableService.viewTimetable(classID));
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("days", dayService.findAll());
		model.addAttribute("periods", periodService.findAll());
		timetableService.addTimetable(classID, dayID, periodID, teacherID);
		return "redirect:/searchFirst?classID=" + classID;
	}
	
	@GetMapping("/timetable/{classID}/{periodID}/{dayID}/delete")
	public String delete(@PathVariable int classID, @PathVariable int periodID, @PathVariable int dayID, RedirectAttributes redirect) {
		timetableService.deleteTimetable(classID, periodID, dayID);;
		redirect.addFlashAttribute("success", "Deleted successfully!");
		return "redirect:/searchFirst?classID=" + classID;
	}
	
	@GetMapping("/viewschedule")
	public String viewSchedule(HttpServletRequest request, Model model) {
		Account account;
		String username = request.getUserPrincipal().getName();
		account = accountService.getOne(username);
		Teacher t = teacherService.getOne(account.getAccountID());
		model.addAttribute("teacher", t);
		model.addAttribute("schedules", timetableService.viewSchedule(t.getTeacherID()));
		return "XemLichDay";
	}
	
}

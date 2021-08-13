package com.mock.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mock.project.entity.Class;
import com.mock.project.service.ClassService;
import com.mock.project.service.TeacherService;
import com.mock.project.service.TimetableService;
import com.mock.project.service.start_yearService;

@Controller
public class ClassController {
	
	@Autowired
	private TimetableService timetableService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private start_yearService start_yearService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping("addclass")
	public String addClass(Model model) {
		model.addAttribute("newClass", new Class());
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("startyear", start_yearService.findAll());
		return "TaoMoiLop";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("newClass") Class newClass, BindingResult bind,Model model) {
		model.addAttribute("teachers", teacherService.findAll());
		model.addAttribute("startyear", start_yearService.findAll());
		if(bind.hasErrors()) {
			return "403";
		}
		Class a= classService.findByNameAndYear(newClass.getClassName(),newClass.getStartYear());
		if(a != null) {
			model.addAttribute("fail","Tên lớp bị trùng");
		}else {
			model.addAttribute("success","Thêm lớp thành công");	
		    classService.saveClass(newClass);
		    timetableService.newTable2();
		}
		return "TaoMoiLop";
	}
	
	
	
}

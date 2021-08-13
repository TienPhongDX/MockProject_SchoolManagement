package com.mock.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.dto.NewStudentDTO;
import com.mock.project.entity.Account;
import com.mock.project.entity.Student;
import com.mock.project.service.AccountService;
import com.mock.project.service.ClassService;
import com.mock.project.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/studentls")
	public String studentls(Model model) {
		try {
		model.addAttribute("students", studentService.findAll());
		System.out.println(model);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "TimKiemHocSinh";
	}
	
	@GetMapping("/addstudent")
	public String student(Model model) {
		model.addAttribute("classes", classService.selectClass());
		model.addAttribute("newStudent", new NewStudentDTO());
		return "ThemHocSinh";
	}
	
	@PostMapping("/saveStudent")
	public String add(@Validated @ModelAttribute("newStudent") NewStudentDTO student, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request, Model model) {
		try {
			Account a= accountService.getOne(student.getUsername());
			model.addAttribute("classes", classService.selectClass());
			if(a != null) {
				model.addAttribute("fail","Username đã tồn tại");
			}else {
				model.addAttribute("success","Thêm học sinh thành công");	
				studentService.insert_student(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ThemHocSinh";
	}
	
	@RequestMapping("viewstudent")
	public String viewStudent(Model model) {
		model.addAttribute("students", studentService.findAll());
		model.addAttribute("classes", classService.findAllOrderByGradeID());
		return "DanhSachHocSinh";
	}
	
	@GetMapping("/sortStudent")  
	public String searchClass(@RequestParam("classID") Integer classID, Model model)  
	{
		model.addAttribute("foundClass", classService.getOne(classID));
		model.addAttribute("cnName", classService.findTeacherCnNameByClassID(classID));
		model.addAttribute("classes", classService.findAllOrderByGradeID());
		model.addAttribute("students", studentService.sortStudents(classID));
		System.out.println(model);
	    return "DanhSachHocSinh";  
	}
	@GetMapping("/studentls/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		try {
			model.addAttribute("student", studentService.getOne(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SuaHocSinh";
	}
	@PostMapping("/student/save")
	public String save(@Validated Student student, BindingResult result, RedirectAttributes redirect,
			HttpServletRequest request) {
		try {
			String name = request.getParameter("name");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(request.getParameter("birthday"));
			java.sql.Date birthday = new java.sql.Date(parsed.getTime());
			String gender = request.getParameter("gender");

			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String photo = request.getParameter("photo");
			Integer classStudying = Integer.parseInt(request.getParameter("classStudying"));

			if (result.hasErrors()) {
				return "SuaHocSinh";
			}
			Student student1 = studentService.getOne(Integer.parseInt(request.getParameter("id")));
			student1.setName(name);
			student1.setGender(gender);
			student1.setBirthday(birthday);
			student1.setAddress(address);
			student1.setPhone(phone);
			if(classStudying!=0) {
				student1.setClassStudying(classStudying);
			}
			else {
				student1.setClassStudying(Integer.parseInt(null));
			}
			
			student1.setPhoto(photo);
			studentService.save(student1);
			redirect.addFlashAttribute("success", "Saved student successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/viewstudent";
	}
	@GetMapping("/findstudent")
	public String students(Model model) {
		try {
		model.addAttribute("students", studentService.findAll());;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "TimKiemHocSinh";
	}
	
	@GetMapping("/student/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/student";
		}

		model.addAttribute("students", studentService.search("%" + s + "%"));
		return "TimKiemHocSinh";
	}
	@GetMapping("/student/editpersonal")
	public String editPersonal(Model model, HttpServletRequest request) {
		try {
			Account account;
			String username = request.getUserPrincipal().getName();
			account = accountService.getOne(username);
			long id=account.getAccountID();
			System.out.println(id);
			model.addAttribute("student", studentService.getOne(id));
//			model.addAttribute("subjects", subjectService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "EditPersonalStudent";
	}
	@PostMapping("/student/saveinfo")
	public String saveInfo(@Validated Student student, BindingResult result, RedirectAttributes redirect,
			HttpServletRequest request) {
		try {
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String photo= request.getParameter("photo");
			if (result.hasErrors()) {
				return "/";
			}
			Student student1 = studentService.getOne(Integer.parseInt(request.getParameter("id")));
			student1.setAddress(address);
			student1.setPhone(phone);
			student1.setPhoto(photo);
			studentService.save(student1);
			redirect.addFlashAttribute("success", "Saved info successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
}

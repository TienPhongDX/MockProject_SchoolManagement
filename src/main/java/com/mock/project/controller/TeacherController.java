package com.mock.project.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mock.project.dto.ChangePasswordDTO;
import com.mock.project.dto.TeacherRegisterDTO;
import com.mock.project.entity.Account;
import com.mock.project.entity.Teacher;
import com.mock.project.service.AccountService;
import com.mock.project.service.SubjectService;
import com.mock.project.service.TeacherService;
import com.mock.project.service.TimetableServiceImpl;

@Controller
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SubjectService subjectService;

	@Autowired
	private TimetableServiceImpl timetableService;
	
	@GetMapping("/teacherls")
	public String teacherls(Model model) {
		try {
			model.addAttribute("teachers", teacherService.findAll());
			System.out.println(model);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ListTeacher";
	}
	
	@GetMapping("/change")
	public String teacher() {
		return "ChangePassword";
	}
	

	@GetMapping("/teacherls/{id}/delete")
	public String delete(@PathVariable long id, RedirectAttributes redirect) {
		Teacher tc = teacherService.getOne(id);
		teacherService.delete_teacher(tc);
		redirect.addFlashAttribute("success", "Deleted teacher successfully!");
		return "redirect:/teacherls";
	}

	@GetMapping("/teacher/register")
	public String register(Model model) {
		model.addAttribute("teacher", new TeacherRegisterDTO());
		model.addAttribute("subjects", subjectService.findAll());
		return "register";
	}

	@GetMapping("/teacherls/{id}/edit")
	public String edit(@PathVariable int id,  Model model) {
		try {
			model.addAttribute("teacher", teacherService.getOne(id));
			model.addAttribute("subjects", subjectService.findAll());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "EditTeacher";
	}
	
	@GetMapping("/teacher/editpersonal")
	public String editPersonal(Model model, HttpServletRequest request) {
		try {
			Account account;
			String username = request.getUserPrincipal().getName();
			account = accountService.getOne(username);
			long id=account.getAccountID();
			System.out.println(id);
			model.addAttribute("teacher", teacherService.getOne(id));
			model.addAttribute("subjects", subjectService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "EditPersonalInformation";
	}
	@PostMapping("/teacher/saveinfo")
	public String saveInfo(@Validated Teacher teacher, BindingResult result, RedirectAttributes redirect,
			HttpServletRequest request) {
		try {
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String photo= request.getParameter("photo");
			if (result.hasErrors()) {
				return "EditTeacher";
			}
			Teacher teacher1 = teacherService.getOne(Integer.parseInt(request.getParameter("id")));
			teacher1.setAddress(address);
			teacher1.setPhone(phone);
			teacher1.setPhoto(photo);
			teacherService.save(teacher1);
			redirect.addFlashAttribute("success", "Saved info successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}

	@PostMapping("/teacher/save")
	public String save(@Validated Teacher teacher, BindingResult result, RedirectAttributes redirect,
			HttpServletRequest request) {
		try {
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date parsed = format.parse(request.getParameter("birthday"));
			java.sql.Date birthday = new java.sql.Date(parsed.getTime());

			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String photo= request.getParameter("photo");

			Float salary = Float.parseFloat(request.getParameter("salary"));
			int subjectID = Integer.parseInt(request.getParameter("subjectID"));

			if (result.hasErrors()) {
				return "EditTeacher";
			}
			Teacher teacher1 = teacherService.getOne(Integer.parseInt(request.getParameter("id")));
			teacher1.setName(name);
			teacher1.setGender(gender);
			teacher1.setBirthday(birthday);
			teacher1.setAddress(address);
			teacher1.setPhone(phone);
			teacher1.setSalary(salary);
			teacher1.setSubjectID(subjectID);
			teacher1.setPhoto(photo);
			teacherService.save(teacher1);
			redirect.addFlashAttribute("success", "Saved employee successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/teacherls";
	}

	@PostMapping("/teacher/add")
	public String add(@Validated @ModelAttribute("teacher") TeacherRegisterDTO teacher, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request) {
		try {
			// save data
			teacherService.insert_teacher(teacher);
			timetableService.newTable3();

			redirect.addFlashAttribute("success", "Add teacher successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/teacherls";
	}

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
	}
	@GetMapping("/teacher/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/teacherls";
		}
		model.addAttribute("teachers", teacherService.search("%" + s + "%"));
		return "ListTeacher";
	}
	
	//Search teacher cho guest
	
		@GetMapping("/guest/teacher/search")
		public String guestSearch(@RequestParam("s") String s, Model model) {
			if (s.equals("")) {
				return "redirect:/teacherls";
			}
			model.addAttribute("teachers", teacherService.search("%" + s + "%"));
			return "TimKiemGiaoVien";
		}
		
		@GetMapping("/findteacher")
		public String teacher(Model model) {
			try {
//			model.addAttribute("teachers", teacherService.findAll());;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return "TimKiemGiaoVien";
		}

}

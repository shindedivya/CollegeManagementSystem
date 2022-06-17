package com.springboot.college.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.college.entity.College;
import com.springboot.college.service.CollegeService;

@Controller
public class CollegeController {

	@Autowired
	private CollegeService collegeService;
	//private CollegeService collegeService;

	public CollegeController(CollegeService collegeService) {
		super();
		this.collegeService = collegeService;
	}
	
	@RequestMapping(value="/colleges/add",method=RequestMethod.GET)
	public void addCollegeList() {
		collegeService.addCollege();
		}
	
	@GetMapping("/index")
	public String createHomePage(Model model) {
		model.addAttribute("index");
		return "index";
	}
	
	/*@GetMapping("/course")
	public String createCourse(Model model) {
		model.addAttribute("course");
		return "course";
	}*/
	
	@GetMapping("/login")
	public String createLoginPage(Model model) {
		model.addAttribute("login");
		return "login";
	}
	
	@GetMapping("/colleges")
	public String listColleges(Model model) {
		model.addAttribute("colleges", collegeService.getAllColleges());
		return "colleges";
	}
	
	@GetMapping("/colleges/new")
	public String createCollegeForm(Model model) {
		
		College college = new College();
		model.addAttribute("college", college);
		return "create_college";
		
	}
	
	@PostMapping("/colleges")
	public String saveCollege(@ModelAttribute("college") College college) {
		collegeService.saveCollege(college);
		return "redirect:/colleges";
	}
	
	@GetMapping("/colleges/edit/{id}")
	public String editCollegeForm(@PathVariable Long id, Model model) {
		model.addAttribute("college", collegeService.getCollegeById(id));
		return "edit_college";
	}

	@PostMapping("/colleges/{id}")
	public String updateCollege(@PathVariable Long id,
			@ModelAttribute("college") College college,
			Model model) {
		
		College existingCollege = collegeService.getCollegeById(id);
		existingCollege.setId(id);
		existingCollege.setName(college.getName());
		existingCollege.setEmail(college.getEmail());
		
		collegeService.updateCollege(existingCollege);
		return "redirect:/colleges";		
	}
	
	
	@GetMapping("/colleges/{id}")
	public String deleteCollege(@PathVariable Long id) {
		collegeService.deleteCollegeById(id);
		return "redirect:/colleges";
	}
	
}

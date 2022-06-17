package com.springboot.college.service;

import java.util.List;

import com.springboot.college.entity.College;

public interface CollegeService {

List<College> getAllColleges();
	
College saveCollege(College college);
	
College getCollegeById(Long id);
	
College updateCollege(College College);
	
	void deleteCollegeById(Long id);

	void addCollege();
}

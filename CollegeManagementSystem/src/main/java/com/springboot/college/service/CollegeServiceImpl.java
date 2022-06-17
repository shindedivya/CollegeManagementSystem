package com.springboot.college.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.college.entity.College;
import com.springboot.college.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;
//private CollegeRepository collegeRepository;
	
	public CollegeServiceImpl(CollegeRepository collegeRepository) {
		super();
		this.collegeRepository = collegeRepository;
	}

	@Override
	public List<College> getAllColleges() {
		return collegeRepository.findAll();
	}

	@Override
	public College saveCollege(College college) {
		return collegeRepository.save(college);
	}

	@Override
	public College getCollegeById(Long id) {
		return collegeRepository.findById(id).get();
	}

	@Override
	public void addCollege() {
		ArrayList<College> college=new ArrayList<College>();
		//college.add(new College("abc", "abc@gmail.com"));
		college.add(new College("MGM", "mgm@gmail.com"));
		
		for(College College:college) {
			collegeRepository.save(College);
		}
		
	}
	
	@Override
	public College updateCollege(College college) {
		return collegeRepository.save(college);
	}

	@Override
	public void deleteCollegeById(Long id) {
		collegeRepository.deleteById(id);	
	}
}

package com.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springboot.college.entity.College;
import com.springboot.college.repository.CollegeRepository;
import com.springboot.college.repository.StudentRepository;

@SpringBootApplication
public class CollegeManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CollegeManagementSystemApplication.class, args);
	}

	@Autowired
	private CollegeRepository collegeRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		/*College college1 = new College("MGM", "mgm@gmail.com");
		collegeRepository.save(college1);*/
	}
}

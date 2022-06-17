package com.springboot.college.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.college.entity.College;
import com.springboot.college.entity.Student;
import com.springboot.college.repository.StudentRepository;
import com.springboot.college.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public void addStudent() {
		ArrayList<Student> student=new ArrayList<Student>();
		student.add(new Student("Divya","Shinde", "div@gmail.com"));
		
		
		for(Student Student:student) {
			studentRepository.save(Student);
		}
		
	}
	
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);	
	}

}

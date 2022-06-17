package com.springboot.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.college.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}

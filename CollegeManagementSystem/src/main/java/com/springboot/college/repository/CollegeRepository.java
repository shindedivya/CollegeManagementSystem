package com.springboot.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.college.entity.College;

public interface CollegeRepository extends JpaRepository<College,Long> {

}

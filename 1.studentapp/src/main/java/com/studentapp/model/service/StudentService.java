package com.studentapp.model.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.studentapp.web.entities.Student;



public interface StudentService {
	public List<Student> findAllStudents();
	public List<Student> findStudentsWithSorting(String field);
	public Page<Student> findStudentsWithPagination(int offset, int pageSize);
	public Page<Student> findStudentsWithPaginationAndSorting(int offset, int pageSize, String field);
}

package com.studentapp.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.studentapp.model.dao.StudentDao;
import com.studentapp.web.entities.Student;

@Service
public class StudentDerviceImpl implements StudentService {

	private StudentDao studentDao;

	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> findAllStudents() {
		return studentDao.findAll();
	}

	@Override
	public List<Student> findStudentsWithSorting(String field) {
		return studentDao.findAll(Sort.by(Sort.Direction.ASC, field));
	}

	@Override
	public Page<Student> findStudentsWithPagination(int offset, int pageSize) {
		return studentDao.findAll(PageRequest.of(offset, pageSize));
	}

	@Override
	public Page<Student> findStudentsWithPaginationAndSorting(int offset, int pageSize, String field) {
		return studentDao.findAll(PageRequest.of(offset, pageSize, Sort.by(field)));
	}

}

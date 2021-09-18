package com.studentapp.model.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.studentapp.web.entities.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{
	
	@Query("select u from Student u where u.email = ?1")
	Student getStudentByEmail(String email);
	
	@Query(value = "select * from student_table s where s.email=?1",nativeQuery = true)
	Student getStudentByEmailNativeQueryExample(String email);
	
	@Transactional
	@Modifying
	@Query(value = "update student_table s set s.firstName=?1 where s.studentId=1",nativeQuery = true)
	void updateStudent(String firstName);
	
//	Spring is going to define the sql query from the methodName
	List<Student> findByFirstName(String firstName);
	List<Student> findByLastName(String lastName);
	List<Student> findByEmail(String email);
	List<Student> findByFirstNameAndLastName(String firstName,String lastName);
	
	
}

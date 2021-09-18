package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.studentapp.model.dao.StudentDao;
import com.studentapp.web.entities.Student;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private StudentDao studentDao;
	
	@Autowired
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public static void main(String[] args) {
		ApplicationContext ctx= SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student s1=new Student("Himanshu","Judge","himanshu@gmail.com");
		Student s2=new Student("Ravi","Sharma","ravi@gmail.com");
		Student s3=new Student("Ashu","Mann","ashu@gmail.com");
		
//		studentDao.save(s1);
//		studentDao.save(s2);
//		studentDao.save(s3);
		
		Student studentByEmail = studentDao.getStudentByEmail("himanshu@gmail.com");
		Student studentByEmailNative = studentDao.getStudentByEmailNativeQueryExample("himanshu@gmail.com");
		
//		System.out.println("student is :"+studentByEmail);
//		System.out.println("native : "+studentByEmailNative);
	
		studentDao.updateStudent("Kamal");
	}

}

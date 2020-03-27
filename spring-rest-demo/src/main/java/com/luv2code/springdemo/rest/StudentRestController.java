package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;
@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents=new ArrayList<Student>();
	
	@PostConstruct
	public void loadData() {
		theStudents.add(new Student("Anant","Tripathi"));
		theStudents.add(new Student("Ashu","Panwar"));
		theStudents.add(new Student("Mohit","Deb"));
	}
	
	@GetMapping("/student")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("studentOnID/{studentID}")
	public Student studentID(@PathVariable int studentID) {
		
		if((studentID>=theStudents.size()) || (studentID<0)) {
			throw new StudentNotFound("Student ID is not found");
		}
		
		
		return theStudents.get(studentID);
	}
	

}

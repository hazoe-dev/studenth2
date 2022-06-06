package com.ha.studentmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.service.IStudentService;

@RestController
public class StudentApi {
	@Autowired
	private IStudentService studentService;
	
	@GetMapping("/checkStudent/{id}")
	public ResponseEntity<Boolean> checkStudentID(@PathVariable Long id) {
		return  ResponseEntity.ok((Boolean)studentService.existsStudentId(id));
	}
	
}

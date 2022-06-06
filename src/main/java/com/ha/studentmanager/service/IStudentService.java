package com.ha.studentmanager.service;

import java.util.List;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;

public interface IStudentService {
	public Student getStudent(Long id);

	public List<Student> getStudents();

	public StudentDto saveStudent(StudentDto studentDto);
	
	public void deleteStudent(Long id);

	public Boolean existsStudentId(Long id);

	public List<Long> deleteStudent(Long[] ids);
	
}

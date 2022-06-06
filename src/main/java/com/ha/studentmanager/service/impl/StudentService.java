package com.ha.studentmanager.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ha.studentmanager.dto.StudentDto;
import com.ha.studentmanager.model.Student;
import com.ha.studentmanager.repository.StudentRepository;
import com.ha.studentmanager.service.IStudentService;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Student not found by id = " + id));
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Transactional
	@Override
	public StudentDto saveStudent(StudentDto studentDto) {
		Student student = new Student();
		BeanUtils.copyProperties(studentDto, student);
				
		String sBirthday = studentDto.getBirthday();  
		
		if(sBirthday != null && sBirthday != "") {
		    try {
				Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(sBirthday);
				student.setBirthday(birthday);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Student newStudent = studentRepository.save(student );
		StudentDto newStudentDto = new StudentDto();
		BeanUtils.copyProperties(newStudent, newStudentDto);
		
		Date birthday = newStudent.getBirthday();
		if(birthday != null) {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDate = formatter.format(birthday);
			newStudentDto.setBirthday(formattedDate);
		}
		
		return newStudentDto ;
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public Boolean existsStudentId(Long id) {
		return studentRepository.existsById(id);
	}

	@Override
	public List<Long> deleteStudent(Long[] ids) {
		List<Long> results = new ArrayList<Long>();
		for (Long id : ids) {
			studentRepository.deleteById(id);
			results.add(id);
		}
		return results;
	}

}

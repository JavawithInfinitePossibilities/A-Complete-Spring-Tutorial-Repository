/**
 * 
 */
package com.tutorials.sid.spring.controler;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tutorials.sid.spring.entities.StudentDB;
import com.tutorials.sid.spring.model.Student;
import com.tutorials.sid.spring.repositories.student.IStudentRepository;

/**
 * @author Lenovo <br/>
 *         URL: http://localhost:8080/Studentseminar/
 *         http://localhost:8080/Studentseminar/studentform
 *         http://localhost:8080/Studentseminar/student
 *         http://localhost:8080/Studentseminar/students
 *
 */
@Controller
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@Autowired
	private IStudentRepository studentRepository;

	@RequestMapping("/")
	public ModelAndView displayStudentDetail(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("studentsubmit");
		student.setId(1);
		student.setName("Sid");
		student.setScore(100);
		mav.addObject("student", student);
		return mav;
	}

	@RequestMapping("/studentsave")
	public ModelAndView saveStudentDetail(@ModelAttribute("student") Student student) {
		ModelAndView mav = new ModelAndView("result");
		StudentDB studentDB = new StudentDB(student.getId(), student.getName(), student.getScore());
		studentRepository.save(studentDB);
		return mav;
	}

	@RequestMapping("/student")
	@Transactional(readOnly = true)
	@Cacheable("student-cache")
	public ModelAndView studentDetail() {
		ModelAndView mav = new ModelAndView("student");
		StudentDB student = studentRepository.findById(1L).get();
		Student studentModel = new Student(student.getId(), student.getName(), student.getTestScore());
		mav.addObject("student", studentModel);
		return mav;
	}

	@RequestMapping("/students")
	@Transactional(readOnly = true)
	@Cacheable("student-cache")
	public ModelAndView studentDetails() {
		ModelAndView mav = new ModelAndView("studentdetails");
		List<StudentDB> studentDBs = studentRepository.findAll();
		List<Student> students = studentDBs.stream().map(studentDB -> {
			return new Student(studentDB.getId(), studentDB.getName(), studentDB.getTestScore());
		}).collect(Collectors.toList());
		mav.addObject("students", students);
		return mav;
	}

}

package com.tutorials.sid.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tutorials.sid.spring.entities.StudentDB;
import com.tutorials.sid.spring.repositories.student.IStudentRepository;

@SpringBootTest(classes = Division06CreateRESTCRUDAPI.class)
class Division06CreateRESTCRUDAPITest {

	@Autowired
	private IStudentRepository studentRepo;

	@Test
	void testSaveStudent() {
		StudentDB studentDB = new StudentDB();
		// studentDB.setId(1l);
		studentDB.setName("Siddhant");
		studentDB.setTestScore(100);

		studentRepo.save(studentDB);

		// Select
		StudentDB saveStudent = studentRepo.findById(1l).get();
		System.out.println(saveStudent);

		// Update

		studentDB.setTestScore(90);
		studentRepo.save(studentDB);
		StudentDB updateStudent = studentRepo.findById(1l).get();
		System.out.println("Updated student :" + updateStudent);

		// Delete
		/*
		 * studentRepo.deleteById(1L); StudentDB deleteStudent =
		 * studentRepo.findById(1l).orElse(null); System.out.println("Deleted student:"
		 * + deleteStudent);
		 */

	}

}

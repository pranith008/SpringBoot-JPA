package com.spring.SpringBoot.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.SpringBoot.Exception.StudentNotFoundException;
import com.spring.SpringBoot.entity.Student;
import com.spring.SpringBoot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;  //Hibernate session

	public Student saveStudent (Student s1) {
		return studentRepository.save(s1);
		
	}

	public List<Student> saveMultipleStudent(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	public Student getSingleStudent(int rollno) {
		return studentRepository.findById(rollno).orElse(null);
	}
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentsByDepartment(String deptName) {
//		return studentRepository.getDeptWiseStudent(deptName);
		return studentRepository.findByDepartment(deptName);
	}

	public List<Student> getStudentsByGender(String gender) {
//		return studentRepository.getGenderWiseStudent(gender);
		return studentRepository.findByGender(gender);
	}

	public List<String> getAllDepartmentNames() {
		return studentRepository.getDistinctByDepartment();
	}
	
	public List<String> getAllDepartmentNames1() {
		List<Student> students=getAllStudents();
		return students.stream()
		.map(Student::getDepartment)
		.distinct()
		.toList();
	}


	public List<Student> getStudentsGreaterThanCertainPercentage(double basePercentage) {
		return studentRepository.findByPerGreaterThan(basePercentage);
	}

	public List<Student> getStudentsAfterDob(LocalDate dob) {
		return studentRepository.findByDobAfter(dob);
	}

	public void deleteStudent(int rollnumber) throws StudentNotFoundException{
		if(studentRepository.existsById(rollnumber)) {
			studentRepository.deleteById(rollnumber);
		}
		else {
			throw new StudentNotFoundException("Student with roll number "+rollnumber+" not found ");
		}
		
	}

	public void updateStudent(int rollnumber, Student updatedStudent) {
		if(studentRepository.existsById(rollnumber)) {
			//logic for update
			Student studFromDb=studentRepository.findById(rollnumber).orElse(null);
			studFromDb.setDepartment(updatedStudent.getDepartment());
			studFromDb.setDob(updatedStudent.getDob());
			studFromDb.setMobileNumber(updatedStudent.getMobileNumber());
			studFromDb.setPer(updatedStudent.getPer());
			studFromDb.setSname(updatedStudent.getSname());
			studentRepository.save(studFromDb);
		}
		else {
			throw new StudentNotFoundException("Student with roll number "+rollnumber+" not found ");
		}
		
		
	}

	

}

package com.spring.SpringBoot.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringBoot.Exception.StudentNotFoundException;
import com.spring.SpringBoot.entity.Student;
import com.spring.SpringBoot.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save-student")  //endpoint //postmapping for insert query
	public String saveStudent()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		studentService.saveStudent(s1);
		return "Record Inserted Successfully";
	}
	
	@PostMapping("/save-studentRE")  //endpoint
	public ResponseEntity<String> saveStudentRE()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		studentService.saveStudent(s1);
		return new ResponseEntity<String>("Record Inserted Successfully", HttpStatus.CREATED);  //201
	}
	
	@PostMapping("/save-student1")  //endpoint
	public Student saveStudent1()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student1Re")  //endpoint
	public ResponseEntity<Student> saveStudent1RE()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		Student savedStudent=studentService.saveStudent(s1);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	@PostMapping("/save-student-using-request-param")  //endpoint
	public Student saveStudentUsingRequestParam(@RequestParam("a") double percent, @RequestParam("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-request-param1")  //endpoint
	public Student saveStudentUsingRequestParam1(@RequestParam double percent, @RequestParam String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-pathvariable/{a}/{b}")  //endpoint
	public Student saveStudentUsingPathVariable(@PathVariable("a") double percent, @PathVariable("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-pathvariable1/{percent}/{studName}")  //endpoint
	public Student saveStudentUsingPathVariable1(@PathVariable double percent, @PathVariable String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-requestbody")  //endpoint
	public Student saveStudentUsingRequestBody(@RequestBody Student s1)
	{
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-multiple-student-using-requestbody")  //endpoint
	public List<Student> saveMultipleStudentUsingRequestBody(@RequestBody List<Student> students)
	{
		List<Student> savedStudents=studentService.saveMultipleStudent(students);
		return savedStudents;
	}
	
	@PostMapping("/save-multiple-student-using-requestbodyRE")  //endpoint
	public ResponseEntity<List<Student>> saveMultipleStudentUsingRequestBodyRE(@RequestBody List<Student> students)
	{
		List<Student> savedStudents=studentService.saveMultipleStudent(students);
		return new ResponseEntity<List<Student>>(savedStudents,HttpStatus.CREATED);
	}
	
	@GetMapping("/get-all-students")  //getmapping for select query
	public List<Student> getAllStudents()
	{
		List<Student> students=studentService.getAllStudents();
		return students;
	}
	
	@GetMapping("/get-all-students-re")  //select
	public ResponseEntity<List<Student>> getAllStudentsRe()
	{
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);   //200
	}
	
	@GetMapping("/get-single-student/{rollno}")  //select
	public Student getSingleStudent(@PathVariable int rollno)
	{
		Student student=studentService.getSingleStudent(rollno);
		return student;
	}
	
	
	@GetMapping("/get-students-by-department/{deptName}")  //select
	public List<Student> getStudentsByDepartment(@PathVariable String deptName)
	{
		List<Student> deptWiseStudents=studentService.getStudentsByDepartment(deptName);
		return deptWiseStudents;
	}
	
	@GetMapping("/get-students-by-gender/{gender}")  //select
	public List<Student> getStudentsByGender(@PathVariable String gender)
	{
		List<Student> genderWiseStudents=studentService.getStudentsByGender(gender);
		return genderWiseStudents;
	}
	
	@GetMapping("/get-all-department-names")  //select
	public List<String> getAllDepartmentNames()
	{
		List<String> departmentNames=studentService.getAllDepartmentNames();
		return departmentNames;
	}
	
	@GetMapping("/get-all-department-names1")  //select
	public List<String> getAllDepartmentNames1()
	{
		List<String> departmentNames=studentService.getAllDepartmentNames1();
		return departmentNames;
	}
	
	@GetMapping("/get-students-greater-than-certain-percentage/{basePercentage}")  //select
	public List<Student> getStudentsGreaterThanCertainPercentage(@PathVariable double basePercentage)
	{
		List<Student> students=studentService.getStudentsGreaterThanCertainPercentage(basePercentage);
		return students;
	}
	
	@GetMapping("/get-students-after-dob/{dob}")  //select
	public List<Student> getStudentsAfterDob(@PathVariable LocalDate dob)
	{
		List<Student> students=studentService.getStudentsAfterDob(dob);
		return students;
	}

	@DeleteMapping("/delete-student/{rollnumber}")  //deletemapping is for delete query
	public String deleteStudent(@PathVariable int rollnumber)
	{
		try
		{
		studentService.deleteStudent(rollnumber);
		return "Student Record Deleted";
		}
		catch(StudentNotFoundException ex1)
		{
			return ex1.getMessage();
		}
	}
	
	@DeleteMapping("/delete-student-re/{rollnumber}")  //select
	public ResponseEntity<String> deleteStudentRe(@PathVariable int rollnumber)
	{
		try
		{
		studentService.deleteStudent(rollnumber);
		return new ResponseEntity<String>("Student Record Deleted", HttpStatus.OK);
		}
		catch(StudentNotFoundException ex1)
		{
			return new ResponseEntity<String>(ex1.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update-student/{rollnumber}")  //deletemapping is for delete query
	public String updateStudent(@PathVariable int rollnumber,@RequestBody Student updatedStudent)
	{
		try
		{
		studentService.updateStudent(rollnumber,updatedStudent);
		return "Student Record Updated";
		}
		catch(StudentNotFoundException ex1)
		{
			return ex1.getMessage();
		}
	}
	
	@PutMapping("/update-student-re/{rollnumber}")  //select
	public ResponseEntity<String> updateStudentRe(@PathVariable int rollnumber, @RequestBody Student updatedValues)
	{
		try
		{
		studentService.updateStudent(rollnumber,updatedValues);
		return new ResponseEntity<String>("Student Record Updated", HttpStatus.OK);
		}
		catch(StudentNotFoundException ex1)
		{
			return new ResponseEntity<String>( ex1.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}

/*
To Accept input from user we have 3 ways
1. @RequestParam
2. @PathVariable
3. @RequestBody
*/
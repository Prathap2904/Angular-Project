package com.task.AngularProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.AngularProject.Entity.Student;
import com.task.AngularProject.Service.StudentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService service;
	
	@PostMapping("/save")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return service.saveStudent(student);
	}
	
	@GetMapping("/allstudent")
	public List<Student> getAllStudent(){
			return service.getAllStudent();
	}
	
	@PutMapping("/update")
	public Student updateStudent( @RequestBody Student student,@RequestParam int id){
		return service.editStudent(id, student);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable int id){
		return service.deleteStudent(id);
	}
}

package com.task.AngularProject.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.task.AngularProject.Entity.Student;
import com.task.AngularProject.Repo.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repo;
	
	public ResponseEntity<Student> saveStudent(Student student){
		return new ResponseEntity<Student>(repo.save(student),HttpStatus.CREATED);
	}
	
	public List<Student> getAllStudent(){
		return repo.findAll();
	}
	
	public Student findStudent(int id){
		Optional<Student> getStudent = repo.findById(id);
		if(getStudent.isPresent()) {
			Student dbStudent= getStudent.get();
			return dbStudent;
		}
		return null;
	}
	
	public Student editStudent(int id, Student student){
		Student dbStudent = findStudent(id);
		if(dbStudent!=null) {
			student.setStudentId(id);
			repo.save(student);
			return student;
		}
		return null;
	}
	
	public ResponseEntity<Student> deleteStudent(int id){
		Student dbStudent= findStudent(id);
		if(dbStudent!=null) {
			repo.delete(dbStudent);
			return new ResponseEntity<Student>(dbStudent,HttpStatus.ACCEPTED);
		}
		return null;
	}
}

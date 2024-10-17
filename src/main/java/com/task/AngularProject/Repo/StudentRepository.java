package com.task.AngularProject.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.AngularProject.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}

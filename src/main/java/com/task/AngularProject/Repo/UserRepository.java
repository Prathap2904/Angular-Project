package com.task.AngularProject.Repo;


import com.task.AngularProject.Entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
	
	User findByuserName(String userName);
}

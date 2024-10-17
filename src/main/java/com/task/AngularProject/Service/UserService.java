package com.task.AngularProject.Service;

import com.task.AngularProject.Entity.User;
import com.task.AngularProject.Repo.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public User saveUser(User user) {
		return repo.save(user);
	}

	public List<User> findAllUser() {
		return repo.findAll();
	}

	public User getUserbyName(String username, String password) {
		User user = repo.findByuserName(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return user;
			}
			return null;
		}
		return null;
	}
}

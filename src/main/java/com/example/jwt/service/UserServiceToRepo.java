package com.example.jwt.service;

import com.example.jwt.model.User;
import com.example.jwt.repository.userRepository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceToRepo {

	private UserRepository userRepository;

	@Autowired
	public UserServiceToRepo(UserRepository userRepositoryImpl) {
		this.userRepository = userRepositoryImpl;
	}

	public void insertUserService(User user, String userName) {
		userRepository.insertUser(user, userName);
	}

}
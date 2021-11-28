package com.example.jwt.service;

import java.util.ArrayList;

import com.example.jwt.repository.userRepository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepositoryImpl) {
		this.userRepository = userRepositoryImpl;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User(username, "", new ArrayList<>());
	}

	public void insertUserService(com.example.jwt.model.User user){
		userRepository.insertUser(user);
	}


}

package com.example.jwt.controller;

import java.io.IOException;

import com.example.jwt.entity.JwtRequest;
import com.example.jwt.entity.JwtResponse;
import com.example.jwt.entity.OAuthException;
import com.example.jwt.model.User;
import com.example.jwt.service.UserServiceToRepo;
import com.example.jwt.utility.GoogleOAuthUtility;
import com.example.jwt.utility.JWTUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	private JWTUtility jwtUtility;
	private UserServiceToRepo userServicetRepo;

	@Autowired
	public HomeController(JWTUtility jwtUtility, UserServiceToRepo userServicetRepo) {
		this.jwtUtility = jwtUtility;
		this.userServicetRepo = userServicetRepo;
	}

	@GetMapping("/")
	public String basicControllerString() {
		return "Hello World";
	}

	@PostMapping("/authenticate")
	// TODO : exception handling
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws IOException, OAuthException {

		GoogleOAuthUtility gAuth = new GoogleOAuthUtility();
		User user = gAuth.verifyUserFromIdToken(jwtRequest.getIdToken());

		userServicetRepo.insertUserService(user, jwtRequest.getUserName());

		final String token = jwtUtility.generateToken(user);

		return new JwtResponse(token);
	}

}

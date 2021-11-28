package com.example.jwt.controller;

import com.example.jwt.entity.JwtRequest;
import com.example.jwt.entity.JwtResponse;
import com.example.jwt.model.User;
import com.example.jwt.service.UserService;
import com.example.jwt.utility.GoogleOAuthUtility;
import com.example.jwt.utility.JWTUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private JWTUtility jwtUtility;

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String basicControllerString() {
		return "Hello World";
	}

	@PostMapping("/authenticate")
	public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

		GoogleOAuthUtility gAuth = new GoogleOAuthUtility();
		User user = gAuth.verifyUserFromIdToken(jwtRequest.getIdToken());

		userService.insertUserService(user);

		final String token = jwtUtility.generateToken(user);
		
		return new JwtResponse(token);
	}

}

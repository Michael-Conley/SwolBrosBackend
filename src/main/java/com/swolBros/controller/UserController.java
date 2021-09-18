package com.swolBros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.swolBros.entity.User;
import com.swolBros.entity.Workout;
import com.swolBros.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// private SendMail sendMail;

	@RequestMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void submitUserDetails(@RequestBody User user) {
		System.out.println(user);

		userRepository.save(user);

	}

	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody User user, String email, String password) {
		System.out.println("Request mapping /login");
		User tempStudent = userRepository.login(user.getEmail(), user.getPassword());
		if (tempStudent == null) {
			return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<User>(tempStudent, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/findUserbyid", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Optional<User> listAllStudent(User user, Integer id) {
		System.out.println("Request mapping /finduserworkout");
		return userRepository.findById(id);
	}

}

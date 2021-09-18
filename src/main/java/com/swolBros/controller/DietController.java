package com.swolBros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swolBros.entity.Diet;
import com.swolBros.entity.User;
import com.swolBros.entity.Workout;
import com.swolBros.repository.DietRepository;
import com.swolBros.repository.UserRepository;
import com.swolBros.repository.WorkOutRepository;


@CrossOrigin
@RestController
public class DietController {

	
	@Autowired
	private DietRepository dietRepository;

//
//	
	@Autowired
	private	UserRepository	userRepository;
//	
//	//Working dont mess with
	@RequestMapping(value="/dietbydietid", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public Optional<Diet> listAlldietsByid(Diet diet, Integer id){
		System.out.println("Request mapping /dietbydietid");
		return dietRepository.findById(id);
	}
//	
	// working 
	@RequestMapping(value="/listalldiets", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public List<Diet> listAlldiets(Diet diet){
		System.out.println("Request mapping /listalldiets");
		return dietRepository.findAll();
	}
//	
//	//working
	@RequestMapping(value="/dietByUserId", 
//			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public ResponseEntity<List<Diet>> userDietById(Integer id){
		System.out.println("Request mapping /dietByUserId");
		
		List<Diet> userDiet = dietRepository.findUserDiet(id);
		return new ResponseEntity<List<Diet>>(userDiet, HttpStatus.OK);
	}
//	
//	//working
	@RequestMapping(value="/savediet", 
//			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public void saveDiet (@RequestBody Diet diet) {
		System.out.println("savediet");
		User user = userRepository.findUser(diet.getUser().getId());
		diet.setUser(user);
		dietRepository.save(diet);
	}
////	
////	
//
//	
//	
//	//working
//	
	@RequestMapping(value="deletedietbyid",
	
	produces=MediaType.APPLICATION_JSON_VALUE,
	method=RequestMethod.GET)
	@ResponseBody
	private void deleteworkoutbyid(Integer id) {
		System.out.println("deletedietbyid");
		dietRepository.deleteUserDietById(id);
		
	
	}
}

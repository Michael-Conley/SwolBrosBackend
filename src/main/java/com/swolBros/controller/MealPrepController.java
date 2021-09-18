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
import com.swolBros.entity.MealPrep;
import com.swolBros.entity.User;
import com.swolBros.repository.MealPrepRepository;
import com.swolBros.repository.UserRepository;

@CrossOrigin
@RestController
public class MealPrepController {

	
	@Autowired
	private MealPrepRepository mealpreprepository;
	
	@Autowired
	private	UserRepository	userRepository;
//	
//	//Working dont mess with
	@RequestMapping(value="/mealprepbymealprepid", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public Optional<MealPrep> mealPrepByMealPrepId(MealPrep mealprep, Integer id){
		System.out.println("Request mapping /mealprepbymealprepid");
		return mealpreprepository.findById(id);
	}
//	
	// working 
	@RequestMapping(value="/listallmealpreps", consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public List<MealPrep> listAllMealPreps(MealPrep mealprep){
		System.out.println("Request mapping /listallmealpreps");
		return mealpreprepository.findAll();
	}
//	
//	//working
	@RequestMapping(value="/mealprepByUserId", 
//			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public ResponseEntity<List<MealPrep>> mealPrepByUserId(Integer id){
		System.out.println("Request mapping /mealprepByUserId");
		
		List<MealPrep> userMealPrep = mealpreprepository.findUserMealPrep(id);
		return new ResponseEntity<List<MealPrep>>(userMealPrep, HttpStatus.OK);
	}
//	
//	//working
	@RequestMapping(value="/savemealprep", 
//			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)
	public void saveMealPrep (@RequestBody MealPrep mealprep) {
		System.out.println("savemealprep");
		User user = userRepository.findUser(mealprep.getUser().getId());
		mealprep.setUser(user);
		mealpreprepository.save(mealprep);
	}
////	
////	
//
//	
//	
//	//working
//	
	@RequestMapping(value="deletemealprepbyid",
	
	produces=MediaType.APPLICATION_JSON_VALUE,
	method=RequestMethod.GET)
	@ResponseBody
	private void deleteMealPrepById(Integer id) {
		System.out.println("mealPrepRepository");
		mealpreprepository.deleteUserMealPrepById(id);
		
	
	}
}

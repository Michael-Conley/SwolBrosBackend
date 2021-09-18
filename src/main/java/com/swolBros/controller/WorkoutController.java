package com.swolBros.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.swolBros.entity.User;
import com.swolBros.entity.Workout;
import com.swolBros.repository.UserRepository;
import com.swolBros.repository.WorkOutRepository;

@CrossOrigin
@RestController
public class WorkoutController {

	@Autowired
	private WorkOutRepository workoutRepository;
	@Autowired
	private UserRepository userRepository;

	// Working dont mess with
	@RequestMapping(value = "/workoutbyworkoutid", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Optional<Workout> listAllWorkoutByid(Workout workout, Integer id) {
		System.out.println("Request mapping /workoutbyworkoutid");
		return workoutRepository.findById(id);
	}

	// working
	@RequestMapping(value = "/workoutlistall", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public List<Workout> listAllworkouts(Workout workout) {
		System.out.println("Request mapping /workoutlistall");
		return workoutRepository.findAll();
	}

	// working
	@RequestMapping(value = "/workoutByUserId",
			// consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<List<Workout>> userWorkoutById(Integer id) {
		System.out.println("Request mapping /workoutByUserId");

		List<Workout> userWorkouts = workoutRepository.findUserWorkout(id);
		return new ResponseEntity<List<Workout>>(userWorkouts, HttpStatus.OK);
	}

	// working
	@RequestMapping(value = "/saveworkout",
			// consumes=MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public void saveworkout(@RequestBody Workout workout) {
		System.out.println("saveworkout");
		User user = userRepository.findUser(workout.getUser().getId());
		workout.setUser(user);
		workoutRepository.save(workout);
	}
	//
	//

	// working

	@RequestMapping(value = "deleteworkoutbyid",

			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	private void deleteworkoutbyid(Integer id) {
		System.out.println("deleteworkoutbyid");
		workoutRepository.deleteWorkoutById(id);

	}

}

package com.swolBros.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.swolBros.entity.MealPrep;
import com.swolBros.entity.User;
import com.swolBros.entity.Workout;



public interface WorkOutRepository extends JpaRepository<Workout, Integer>{

	@Query("SELECT W from Workout W where W.user.id =?1")
	List<Workout> findUserWorkout(Integer id);
	@Query("SELECT W from Workout W where W.user.id =?1")
	List<Workout> save(Workout workout, Integer id);

	Workout save(Integer id);

	@Query("DELETE FROM Workout W WHERE W.id=?1")
	@Modifying
	@Transactional
	void deleteWorkoutById (Integer id);



	
	
	
	
}

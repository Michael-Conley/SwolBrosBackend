package com.swolBros.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.swolBros.entity.Diet;
import com.swolBros.entity.MealPrep;
import com.swolBros.entity.Workout;

public interface MealPrepRepository extends JpaRepository<MealPrep, Integer> {

	@Query("SELECT M FROM MealPrep M WHERE M.id=?1")
	Diet listAllMealPreps(Integer id);

	@Query("SELECT M from MealPrep M where M.user.id =?1")
	List<MealPrep> findUserMealPrep(Integer id);

	@Query("SELECT M from MealPrep M where M.user.id =?1")

	Workout save(Integer id);

	@Query("DELETE FROM MealPrep M WHERE M.id=?1")
	@Modifying
	@Transactional
	void deleteUserMealPrepById(Integer id);

}

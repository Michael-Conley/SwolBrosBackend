package com.swolBros.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.swolBros.entity.Diet;
import com.swolBros.entity.Workout;

public interface DietRepository extends JpaRepository<Diet, Integer> {

	@Query("SELECT D FROM Diet D WHERE D.id=?1")
	Diet listAlldiets (Integer id);
//	
	@Query("SELECT D from Diet D where D.user.id =?1")
	List<Diet> findUserDiet(Integer id);
	
	@Query("SELECT D from Diet D where D.user.id =?1")
//	List<Diet> save(Workout workout, Integer id);
//
	Workout save(Integer id);
//
	@Query("DELETE FROM Diet D WHERE D.id=?1")
	@Modifying
	@Transactional
	void deleteUserDietById (Integer id);
	
	
}

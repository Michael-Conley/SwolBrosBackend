package com.swolBros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.swolBros.entity.User;
import com.swolBros.entity.Workout;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT U FROM User U WHERE U.email = ?1 and U.password=?2")
	User login(String email, String password);

	@Query("SELECT U FROM User U WHERE U.id= ?1")
	User findUser(Integer id);

}

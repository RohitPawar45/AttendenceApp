package com.app.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.attendence.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE user_name = :userName", nativeQuery = true)
	List<User> findUserByUserName(@Param("userName") String userName);
	
	@Query(value = "SELECT un.user_name FROM user un WHERE un.user_name = :userName", nativeQuery = true)
	String validateUserName(@Param("userName") String userName);
	
	@Query(value = "SELECT un.password FROM user un WHERE un.password = :password", nativeQuery = true)
	String validatePassword(@Param("password") String password);
	
	@Query(value = "SELECT un.user_name FROM user un WHERE un.user_name = :userName and un.password = :password" , nativeQuery = true)
	String validateUser(@Param("userName") String userName, @Param("password") String password);

}

package com.app.attendence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.attendence.entity.Attendence;

public interface AttendenceRepository extends JpaRepository<Attendence, Integer>{

	  @Query(value = "SELECT * FROM attendence WHERE user_id = :userId", nativeQuery = true)
	  List<Attendence> findAttendeceByUserId(@Param("userId") int userId);
	  
	  @Query(value = "SELECT ad.* FROM attendence ad INNER JOIN user ur on ad.user_id = ur.user_id WHERE ur.user_name = :userName", nativeQuery = true)
	  List<Attendence> findAttendeceByUserName(@Param("userName") String userName);
}

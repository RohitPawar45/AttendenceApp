package com.app.attendence.service;

import java.util.List;

import com.app.attendence.entity.Attendence;

public interface AttendenceService {
	
	List<Attendence> getAllAttendence();
	
	Attendence addAttendence(Attendence attendence);
	
	Attendence updateAttendence(Attendence attendence);

	List<Attendence> findAttendeceByUserId(int userId);

	List<Attendence> findAttendeceByUserName(String userName);
	
}

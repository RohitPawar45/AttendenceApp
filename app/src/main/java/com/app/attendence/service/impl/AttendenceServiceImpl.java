package com.app.attendence.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.app.attendence.entity.Attendence;
import com.app.attendence.repository.AttendenceRepository;
import com.app.attendence.service.AttendenceService;

@Service
public class AttendenceServiceImpl implements AttendenceService{

	private AttendenceRepository attendenceRepository;

	public AttendenceServiceImpl(AttendenceRepository attendenceRepository) {
		this.attendenceRepository = attendenceRepository;
	}

	@Override
	public List<Attendence> getAllAttendence() {
		return attendenceRepository.findAll();
	}

	@Override
	public Attendence addAttendence(Attendence attendence) {
		return attendenceRepository.save(attendence);
	}
	
	@Override
	public Attendence updateAttendence(Attendence attendence) {
		return attendenceRepository.save(attendence);
	}
	
	
	@Override
	public List<Attendence> findAttendeceByUserId(int userId) {
		return attendenceRepository.findAttendeceByUserId(userId);
	}
	
	@Override
	public List<Attendence> findAttendeceByUserName(String userName) {
		return attendenceRepository.findAttendeceByUserName(userName);
	}
	
//	@Override
//	public List<Attendence> getAttendenceForUser(int userId) {
//		List<Attendence> attendence = getAllAttendence();
//		return attendence.stream().filter(a -> a.getUser().getUserId() == userId).collect(Collectors.toList());
//	}
	
}

package com.app.attendence.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.attendence.entity.Attendence;
import com.app.attendence.service.AttendenceService;

@RestController
public class AttendenceController {

	private AttendenceService attendenceService;

	public AttendenceController(AttendenceService attendenceService) {
		super();
		this.attendenceService = attendenceService;
	}
	
	@GetMapping("/attendences")
	public List<Attendence> getAllAttendence() {
		return attendenceService.getAllAttendence();
	}
	
	@PostMapping("/attendences")
	public Attendence addAttendence(@RequestBody Attendence attendence) {
		return attendenceService.addAttendence(attendence);
	}
	
	@PutMapping("/attendences")
	public Attendence updateAttendence(@RequestBody Attendence attendence) {
		return attendenceService.updateAttendence(attendence);
	}
	
	@GetMapping("/attendences/{userId}") 
	public List<Attendence> getAttendenceByUserId(@PathVariable("userId") int userId) {
		return attendenceService.findAttendeceByUserId(userId);
	}
	
	@GetMapping("/attendences/userName/{userName}") 
	public List<Attendence> findAttendeceByUserName(@PathVariable("userName") String userName) {
		return attendenceService.findAttendeceByUserName(userName);
	}
	
}

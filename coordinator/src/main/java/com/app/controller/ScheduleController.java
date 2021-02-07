package com.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.app.dao.SubjectRepository;
import com.app.pojos.Faculty;
import com.app.pojos.ProcessedSchedule;
import com.app.pojos.Schedule;
import com.app.pojos.Subject;
import com.app.service.IScheduleService;

@RestController 
@RequestMapping("/coordinator/schedule")

@CrossOrigin
public class ScheduleController {
	
	
	@Autowired
	private IScheduleService scheduleService;
	@Autowired
	private SubjectRepository subjectRepo;
	@Autowired
	private RestTemplate template;

	public ScheduleController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@PostMapping()//("/upload")
	public ResponseEntity<?> uploadNotice(@RequestBody Schedule schedule) {
		System.out.println("in uploadNotice: " + schedule);
		try {
			scheduleService.uploadSchedule(schedule);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
	}
	
	
//	@GetMapping()//("/all-notices")
//	public ResponseEntity<?> getAllNotices() {
//		System.out.println("in getAllNotices");
//		try {
//			return ResponseEntity.ok(noticeService.getAllNotices());
//		} catch (RuntimeException e) {
//			System.out.println("err in controller " + e);
//		}
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}
	
	@GetMapping()//("/all-notices")
	public ResponseEntity<?> getAllSchedules() {
			try {
	    	List<ProcessedSchedule> processedSchedule=new ArrayList<ProcessedSchedule>();
			List<Schedule> schedules=scheduleService.getWeeklySchedule(LocalDate.now());
			System.out.println(schedules);
//			for (Schedule schedule : schedules) {
//				List<Schedule> schedulesByDate=Arrays.asList(schedule.getCalenderDate());
//			}
			
			for (Schedule schedule : schedules) {
				Faculty newFac=template.getForObject("http://FACULTY-SERVICE/faculty/"+schedule.getFacultyId(),Faculty.class);
				System.out.println(newFac);
				System.out.println(schedule.getSubjectId());
				Subject newSub=subjectRepo.findBySubjectId(schedule.getSubjectId());
				System.out.println(newSub);
				processedSchedule.add(new ProcessedSchedule(newFac,newSub,schedule));
			}
			System.out.println(processedSchedule);
			return ResponseEntity.ok(processedSchedule);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	
	
	
}

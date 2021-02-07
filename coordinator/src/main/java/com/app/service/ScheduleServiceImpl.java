package com.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ScheduleRepository;
import com.app.pojos.Schedule;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class ScheduleServiceImpl implements IScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepo;

	@Override
	public List<Schedule> getWeeklySchedule(LocalDate date) {
		
		// System.out.println(scheduleRepo.findByCalenderDate(date));
		 return scheduleRepo.findByCalenderDate(date);
	}

	@Override
	public List<Schedule> getWeeklySchedule() {
		// TODO Auto-generated method stub
		return scheduleRepo.findAll();
	}

	@Override
	public void uploadSchedule(Schedule schedule) {
		scheduleRepo.save(schedule);
	}

}

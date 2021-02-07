package com.app.service;

import java.time.LocalDate;
import java.util.List;

import com.app.pojos.Schedule;


public interface IScheduleService {

	List<Schedule> getWeeklySchedule(LocalDate date);
	List<Schedule> getWeeklySchedule();
	void uploadSchedule(Schedule schedule);
}

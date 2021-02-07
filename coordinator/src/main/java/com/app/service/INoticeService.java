package com.app.service;

import java.util.List;

import com.app.pojos.Notice;

public interface INoticeService {
	void uploadNotice(Notice notice);
	
	List<Notice> getAllNotices();
   
}

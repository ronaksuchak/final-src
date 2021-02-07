package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.NoticeRepository;
import com.app.pojos.Notice;

@Service // mandatory
@Transactional // optional since it's by default already added on JpaRepository
public class NoticeServiceImpl implements INoticeService {
	
	@Autowired
	private NoticeRepository noticeRepo;

	@Override
	public void uploadNotice(Notice notice) {
		noticeRepo.save(notice);
		
	}

	@Override
	public List<Notice> getAllNotices() {
		
		return noticeRepo.findAll();
	}


}

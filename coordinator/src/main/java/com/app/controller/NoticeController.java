package com.app.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import com.app.pojos.Faculty;
import com.app.pojos.Notice;
import com.app.pojos.ProcessedNotice;
import com.app.service.INoticeService;

@RestController 
@RequestMapping("/coordinator/notice")

@CrossOrigin
public class NoticeController {
	
	
	@Autowired
	private INoticeService noticeService;
	@Autowired
	private RestTemplate template;

	public NoticeController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@PostMapping()//("/upload")
	public ResponseEntity<?> uploadNotice(@RequestBody Notice notice) {
		System.out.println("in uploadNotice: " + notice);
		try {
			noticeService.uploadNotice(notice);
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
	public ResponseEntity<?> getAllNotices() {
			try {
	    	List<ProcessedNotice> processedNotice=new ArrayList<ProcessedNotice>();
			List<Notice> notices=noticeService.getAllNotices();
			System.out.println("all ntices: "+notices);
			for (Notice notice : notices) {
				Faculty newFac=template.getForObject("http://FACULTY-SERVICE/faculty/"+notice.getFaucltyId(),Faculty.class);
				processedNotice.add(new ProcessedNotice(notice,newFac,null));
			}
			return ResponseEntity.ok(processedNotice);
		} catch (RuntimeException e) {
			System.out.println("err in controller " + e);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

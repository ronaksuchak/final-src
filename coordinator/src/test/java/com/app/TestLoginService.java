package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.pojos.Login;
import com.app.service.ILoginService;

@SpringBootTest
class TestLoginService {
	
	
	@Autowired
	private ILoginService loginService;
	

	@Test
	public void testgetUser()
	{
		Login user=loginService.getLoginDetails("cc","cc");
		assertEquals("cc", user.getUserName());
		assertEquals("cc", user.getPassword());
	}
       
}

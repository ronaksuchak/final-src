package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.app.pojos.Student;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class RestControllerTestWithServer {
	
	//randomly available free port is injected in local server port
		@LocalServerPort
		private int serverPort;
		
		// Abstraction of REST client to be used in test scenario
		@Autowired
		private TestRestTemplate template;

	
		@Test
		public void testCoordinatorConrollergetStudent()  {

			Student student = template.getForObject("http://localhost:8081/coordinator/students/34",Student.class);
			assertEquals("new", student.getFirstName());
			assertEquals("new", student.getLastName());
			
		}
		
//	
//		@Test
//		public void testCPUConrollerGetCpuByID()  {
//
//			Product product = template.getForObject
//					("http://localhost:" + serverPort + "/products/cpu/4", Product.class);
//			
//			assertEquals(23745.400390625, product.getPrice());
//			
//		}
//		

}

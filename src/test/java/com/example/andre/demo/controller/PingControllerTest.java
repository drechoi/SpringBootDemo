package com.example.andre.demo.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PingControllerTest {
	
   @LocalServerPort
    private int port;
	   
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void pingShouldReturnAlive(){
		String url = "http://localhost:" + port + "/ping";
		String pingMessage = restTemplate.getForObject(url, String.class);
		String expectedPingMessage = "Alive";
		assertThat(pingMessage, is(equalTo(expectedPingMessage)));
	}
	

}

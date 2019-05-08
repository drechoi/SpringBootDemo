package com.example.andre.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Value("${app.name}")
	private String appName;
	
	@Value("${env}")
	private String env;
	
	@Test
	public void contextLoads() {
		System.out.println(appName);
		System.out.println("Env: " + env);
	}

}

package com.example.andre.demo.repository;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.andre.demo.model.Dummy;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class DummyRepositoryTest {	
	@Autowired
	private DummyRepository dummyRepository;
	
	@Test
	public void ableToGetItemsFromDB(){
		long itemCount = dummyRepository.count();
		
		System.out.println("Item Count: " + itemCount);
		assertThat(itemCount, is(greaterThan(0L)));
	}
	
	@Test
	public void ableToSaveDummyToDB(){
		Dummy dummy1 = new Dummy("D1");
		dummyRepository.save(dummy1);
		
		long itemCount = dummyRepository.count();		
		System.out.println("Item Count: " + itemCount);
		
	}
}

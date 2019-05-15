package com.example.andre.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.andre.demo.YAMLConfig;
import com.example.andre.demo.model.Dummy;
import com.example.andre.demo.repository.DummyRepository;

@RestController
public class DemoController {
	@Autowired
	private DummyRepository dummyRepository;
	
	
	@Autowired
	private YAMLConfig config;
	
	@RequestMapping("/")
	public String index(){
		return "index of " + config.getName();
	}
	
	@GetMapping("/dummy/all/")
	public List<Dummy> getAllDummy(){
		return dummyRepository.findAll();
	}
	
	@GetMapping("/dummy/mulitple_all/")
	public List<Dummy> getMultipleAllDummy(){
		for(int i=0; i<3; i++){
			dummyRepository.findAll();
		}
		
		return dummyRepository.findAll();
	}
	
	@GetMapping("/dummy/{id}")
	public Dummy getDummyById(@PathVariable Long id){
		return dummyRepository.getOne(id);
	}
	
	@GetMapping("/dummy/lazy_create/{name}")
	public Dummy getDummyById(@PathVariable String name){
		Dummy dummy = Dummy.builder().name(name).build();
		return dummyRepository.save(dummy);
	}
	
	@PostMapping("/dummy/create")
	public void create(@RequestBody Dummy dummy){
		dummyRepository.save(dummy);
	}
}

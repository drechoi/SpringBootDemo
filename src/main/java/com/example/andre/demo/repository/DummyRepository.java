package com.example.andre.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.andre.demo.model.Dummy;

@Repository
public interface DummyRepository extends JpaRepository<Dummy, Long>{
	
}
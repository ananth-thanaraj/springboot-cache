package com.cache.controller;

import javax.persistence.Cacheable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cache.model.Employee;
import com.cache.repository.CacheRepository;

@RestController
public class CacheController {
	
	@Autowired
	CacheRepository cacheRepository;
	
	
	@PostMapping("/create")
	@CachePut(value="denmark")
	public String createEmployee(@RequestBody Employee employee) {
		cacheRepository.save(employee);
		return "A new employee has been created";
	}
	
	
	@org.springframework.cache.annotation.Cacheable(value="denmark")	
	public Employee getEmployee(@PathVariable String name) {
		System.out.println("Getting data from the database");
		Employee emp = cacheRepository.findByName(name);
		return emp;		
	}

}

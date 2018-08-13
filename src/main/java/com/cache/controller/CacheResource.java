package com.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.model.Employee;

@RestController
@RequestMapping("cache")
public class CacheResource {

	@Autowired
	CacheController cache;
	
	
	@GetMapping("fetch/{name}")
	public Employee getEmployee(@PathVariable String name) {
		System.out.println("Getting value from Cache");
		return cache.getEmployee(name);
	}
	
}

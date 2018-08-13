package com.cache.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cache.model.Employee;

public interface CacheRepository extends JpaRepository<Employee, Integer>{
	
	
	Employee findByName(String name);

}

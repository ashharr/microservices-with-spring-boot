package com.ashharr.microservices.limits_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashharr.microservices.limits_service.bean.Limits;
import com.ashharr.microservices.limits_service.configuration.Configuration;

@RestController
public class LimitsController {

	@Autowired
	private Configuration configuration;
	
	@GetMapping("limits")
	public Limits getLimits() {
		return new Limits(configuration.getMinimum(), 
				configuration.getMaximum());
//		return new Limits(1, 1000);
	}
}

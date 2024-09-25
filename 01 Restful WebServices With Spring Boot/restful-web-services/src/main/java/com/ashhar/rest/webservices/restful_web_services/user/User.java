package com.ashhar.rest.webservices.restful_web_services.user;

import java.time.LocalDate;

public class User {
	
	private Long id;
	private String name;
	private LocalDate bDate;
	
	public User(Long id, String name, LocalDate bDate) {
		super();
		this.id = id;
		this.name = name;
		this.bDate = bDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getbDate() {
		return bDate;
	}

	public void setbDate(LocalDate bDate) {
		this.bDate = bDate;
	}
	
	
}

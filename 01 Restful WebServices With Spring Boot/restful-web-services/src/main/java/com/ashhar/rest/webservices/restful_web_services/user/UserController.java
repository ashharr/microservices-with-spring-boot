package com.ashhar.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

	private UserDaoService service;
	
	public UserController(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> getUsers(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User getUserById(@PathVariable Long id){
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> postUser(@RequestBody User user){
		User savedUser = service.save(user);
		
		URI Location = ServletUriComponentsBuilder.fromCurrentRequest()
													.path("/{id}")
													.buildAndExpand(savedUser.getId())
													.toUri();
		
		return ResponseEntity.created(Location ).build();
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/users/{id}")
	public void  postUser(@PathVariable Long id){
		service.deleteById(id);
	}
	
	
}

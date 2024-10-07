package com.ashhar.rest.webservices.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

import com.ashhar.rest.webservices.restful_web_services.jpa.PostRepository;
import com.ashhar.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {
	
	private UserRepository userRepository;
	
	private PostRepository postRepository;
	
	public UserJpaController( UserRepository userRepository, PostRepository postRepository) {
		this.userRepository = userRepository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> getUserById(@PathVariable Integer id){
		
		Optional<User> user = userRepository.findById(id);

		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getUsers());
				
		entityModel.add(link.withRel("all-users"));
		
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> postUser(@Valid @RequestBody User user){
		
		User savedUser = userRepository.save(user);
		
		URI Location = ServletUriComponentsBuilder.fromCurrentRequest()
													.path("/{id}")
													.buildAndExpand(savedUser.getId())
													.toUri();
		
		return ResponseEntity.created(Location ).build();
	}
	
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping("/jpa/users/{id}")
	public void  postUser(@PathVariable Integer id){
		userRepository.deleteById(id);
	}
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post>  getPostForUser(@PathVariable Integer id){
		

		Optional<User> user = userRepository.findById(id);

		
		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		return user.get().getPost();
	}
	
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object>  addPostForUser(@PathVariable Integer id, @RequestBody @Valid Post post ){
		
		Optional<User> user = userRepository.findById(id);

		if(user.isEmpty())
			throw new UserNotFoundException("id:"+id);
			
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
		
		URI Location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		
		return ResponseEntity.created(Location ).build();

	}
	
	
	@GetMapping("/jpa/users/{id}/posts/{postId}")
	public Post getPostByIdForUser(@PathVariable Integer id, @PathVariable Integer postId){
		

		Optional<User> user = userRepository.findById(id);
		Optional<Post> post = postRepository.findById(postId);
		
		if(user.isEmpty() | post.isEmpty())
			throw new UserNotFoundException("id:"+id);
		
		return post.get();
	}
	
}

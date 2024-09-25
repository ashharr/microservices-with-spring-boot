package com.ashhar.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {


	
	private static List<User> users = new ArrayList<>();
	
	private static Long usersCount = (long) 0;
	
	
	static {
		users.add(new User( ++usersCount, "Ashhar", LocalDate.of(2006, 6, 4)));
		users.add(new User( ++usersCount, "Nadiya", LocalDate.of(2006, 6, 4)));
		users.add(new User( ++usersCount, "Arsalan", LocalDate.of(2006, 6, 4)));
		users.add(new User( ++usersCount, "Amaan", LocalDate.of(2006, 6, 4)));
		users.add(new User( ++usersCount, "Vishal", LocalDate.of(2006, 6, 4)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(Long id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		User foundUser = users.stream().filter(predicate).findFirst().orElse(null);
		if(foundUser == null) {
			throw new UserNotFoundException("id:"+id);
		}
		return foundUser;
	}
	
	
	public User save(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}

	public void deleteById(Long id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		boolean foundUser = users.removeIf(predicate);
		if(!foundUser) {
			throw new UserNotFoundException("id:"+id);
		}
	}
	
}

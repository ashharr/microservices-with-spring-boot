package com.ashhar.rest.webservices.restful_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		// All requests should be authenticated.
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		
		// If request is not authenticated show popup
		http.httpBasic(withDefaults());
		
		// CSRF disabled -> POST, PUT enabled
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}

}

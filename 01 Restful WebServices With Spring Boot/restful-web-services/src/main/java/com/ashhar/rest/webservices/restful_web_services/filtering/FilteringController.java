package com.ashhar.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering") //field2
	public MappingJacksonValue filtering() {
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new SomeBean("value1","value2", "value3"));
		
		mappingJacksonValue.setFilters(getFilterProvider(mappingJacksonValue) );
		
		return mappingJacksonValue;
	}
	
	
	@GetMapping("/filtering-with-list")
	public MappingJacksonValue getBeansFilteringList() {
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(Arrays.asList(new SomeBean("value1","value2", "value3"),
				new SomeBean("value4","value5", "value6")));
		
		mappingJacksonValue.setFilters(getFilterProvider(mappingJacksonValue));
			
		return mappingJacksonValue;
	}
	
	public static FilterProvider getFilterProvider(MappingJacksonValue mappingJacksonValue) {
		
		SimpleBeanPropertyFilter filter = 
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
		
		FilterProvider filterProvider = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		return filterProvider;
	}
}

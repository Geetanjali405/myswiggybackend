package com.example.myswiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myswiggy.entity.Restaurant;
import com.example.myswiggy.service.RestaurantService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class RestaurantController {
@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/res")
	public String createRes(@RequestBody Restaurant Res) {

	  restaurantService.createRes(Res);
	  return "done";
	  
}
	
	@GetMapping("/restaurant")
	public ResponseEntity<List<Restaurant>> getRestaurant(){
		return new ResponseEntity<List<Restaurant>>(restaurantService.getRestaurants(),HttpStatus.OK);
	}
	
	@GetMapping("/restaurant/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable String id){
		return new ResponseEntity<Restaurant>(restaurantService.getRestaurantById(id),HttpStatus.OK);
	}
	
	
}

package com.example.myswiggy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myswiggy.entity.Restaurant;
import com.example.myswiggy.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	RestaurantRepository ResRep;
	
	public String createRes(Restaurant Rep) {
		ResRep.save(Rep);
		return "Data saved";
	}

	public List<Restaurant> getRestaurants() {
		// TODO Auto-generated method stub
		return ResRep.findAll();
	}

	public Restaurant getRestaurantById(String id) {
		Optional<Restaurant> res=ResRep.findById(id);
		return res.get();
	}
}

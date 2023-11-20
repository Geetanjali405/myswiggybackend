package com.example.myswiggy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myswiggy.entity.Restaurant;

public interface RestaurantRepository extends MongoRepository<Restaurant,String> {

}

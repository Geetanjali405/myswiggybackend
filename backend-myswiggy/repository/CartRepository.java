package com.example.myswiggy.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myswiggy.entity.Cart;


public interface CartRepository extends MongoRepository<Cart,String>{

	public Cart findByUserId(String id);

}

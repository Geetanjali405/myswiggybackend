package com.example.myswiggy.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myswiggy.entity.Delivery;

public interface DeliveryRepository extends MongoRepository<Delivery, String>  {

	public Delivery findByDelId(String delId);

}

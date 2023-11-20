package com.example.myswiggy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.myswiggy.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{

	public User findByEmailAndPassword(String email,String password);
}

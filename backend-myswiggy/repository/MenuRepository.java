package com.example.myswiggy.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.myswiggy.entity.Menu;

public interface MenuRepository extends MongoRepository<Menu,String>{

	public List<Menu> findByRestId(String restId);

}

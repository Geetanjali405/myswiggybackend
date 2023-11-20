package com.example.myswiggy.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import com.example.myswiggy.entity.Menu;
import com.example.myswiggy.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menurep;

	public String createmenu(Menu men) {
		 menurep.save(men);
		return "created";
	}

	public List<Menu> getMenu() {
		return menurep.findAll();
	}

	public Menu getMenuById(String id) {
		// TODO Auto-generated method stub
		Optional<Menu> men=menurep.findById(id);
		return men.get();
	}

	public List<Menu> getMenuByRestaurantId(String restId) {
		// TODO Auto-generated method stub
		return menurep.findByRestId(restId);
		
	}



}

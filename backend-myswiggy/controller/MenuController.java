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

import com.example.myswiggy.entity.Menu;
import com.example.myswiggy.service.MenuService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class MenuController {
	
	@Autowired
	private MenuService menuservice;
	
	@PostMapping("/updatemenu")
	public String createmenu(@RequestBody Menu men) {
		return menuservice.createmenu(men);
		
	}
	
	@GetMapping("/menu")
	public ResponseEntity<List<Menu>> getMenu(){
		return new ResponseEntity<List<Menu>>(menuservice.getMenu(),HttpStatus.OK);
	}
	
	@GetMapping("/menu/{id}")
	public ResponseEntity<Menu> getMenuById(@PathVariable String id){
		return new ResponseEntity<Menu>(menuservice.getMenuById(id),HttpStatus.OK);
	}
	
	@GetMapping("/menus/{restId}")
	public ResponseEntity<List<Menu>> getMenuByRestaurantId(@PathVariable String restId){
		return new ResponseEntity<List<Menu>>(menuservice.getMenuByRestaurantId(restId),HttpStatus.OK);
	}

}

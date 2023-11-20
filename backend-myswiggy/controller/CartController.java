package com.example.myswiggy.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myswiggy.entity.Cart;
import com.example.myswiggy.entity.Menu;
import com.example.myswiggy.service.CartService;
import com.example.myswiggy.service.MenuService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class CartController {
	
	@Autowired 
	private CartService cartService;
	
	@Autowired
	private MenuService menuservice;
	
	@PostMapping("/cart")
	public Cart createCart(@RequestBody Cart cart) {
	    return cartService.createCart(cart);
	}
	
	@GetMapping("/cart/{id}")
	public Cart getCart(@PathVariable String id) {
		  Cart cart = cartService.getCart(id);
		  return cart;
	}
	
	@GetMapping("/carts/user/{id}")
	public Cart getCartByUserId(@PathVariable String id) {
		Cart cart=cartService.getCartByUserId(id);
		return cart;
	}
	
	@PutMapping("/cart/{userId}/{prodId}")
	public Cart addItemToCart(@PathVariable("userId") String userId, @PathVariable("prodId") String prodId) {

	    Menu menu = menuservice.getMenuById(prodId);
	 
	    return cartService.addItemToCart(userId,prodId,menu.price);
	}
	
	@PutMapping("/cartdec/{userId}/{prodId}")
	public Cart decreaseItem(@PathVariable("userId") String userId, @PathVariable("prodId") String prodId) {
		Menu menu = menuservice.getMenuById(prodId);
//		System.out.print(menu.price);
	    return cartService.decreaseItemInCart(userId,prodId,menu.price);
	}
	
	@DeleteMapping("/delete/{userId}/{prodId}")
	public Cart deleteItem(@PathVariable("userId") String userId, @PathVariable("prodId") String prodId ) {
		Menu menu = menuservice.getMenuById(prodId);
		return cartService.deleteItem(userId,prodId,menu.price);
	}
	
	@DeleteMapping("/deletecart/{userId}")
	public String deleteCart(@PathVariable("userId") String userId) {
		return cartService.deleteCart(userId);
	}
	

	
}
	


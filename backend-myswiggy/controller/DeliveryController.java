package com.example.myswiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myswiggy.entity.Cart;
import com.example.myswiggy.entity.Delivery;
import com.example.myswiggy.service.DeliveryService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class DeliveryController {

	@Autowired 
	private DeliveryService delService;
	
	@PostMapping("/createDelivery")
	public Delivery create(@RequestBody Delivery delivery) {
		return delService.create(delivery);
	}
	
	@PostMapping("/delivery/{orderId}")
	public Delivery addOrder(  @PathVariable String orderId) {
		return delService.addOrder(orderId);
	}
	
	@GetMapping("/delivery/6554e024a594227362c3e04d")
	public Delivery getDeliveryy() {
		return delService.getDeliveryby();
	}
	
	@GetMapping("/getstatus/{orderId}")
	public String getOrderStatus(  @PathVariable String orderId) {
		return delService.getOrderStatus(orderId);
	}
	
	
}

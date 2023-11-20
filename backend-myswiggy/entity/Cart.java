package com.example.myswiggy.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;


import lombok.Data;

@Data
public class Cart {

	@Id
	public String id;
	public String userId;
	public String restId;
	public Map<String,Integer> items;
	public String deliveryAddress;
	public Double total;
	public boolean OrderPlaced;

	   
}

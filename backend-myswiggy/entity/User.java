package com.example.myswiggy.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
@Data
@Document(collection = "usersList")
public class User {

	@Id 
	private String id;
	private String userName;
	private String password;
	private String phone;
	private String email;
	private String userType;
	private Boolean firstTimeUser;
	private List<String> favouriteRestaurants;
//	private List<Cart> OrderHistory;
//	private String userAddress	;
	
}

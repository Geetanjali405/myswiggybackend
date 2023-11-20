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

import com.example.myswiggy.entity.User;
import com.example.myswiggy.response.UserProfileResponse;
import com.example.myswiggy.response.UserResponse;
import com.example.myswiggy.service.UserService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserProfileResponse> createUser(@RequestBody User user) {
    	UserProfileResponse resp=new UserProfileResponse();
    	try {
           userService.createUser(user);
    		resp.setMessage("User Created successfully");
    		return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    	}
    	catch(Exception e){
    		resp.setMessage("Error while creating user");
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
    	}
    }
    
    @PostMapping("/signin")
    public User loginUser(@RequestBody User user) {
    		String email=user.getEmail();
			String password=user.getPassword();
			User userres=null;
			if(email!=null && password!=null) {
				 userres=userService.fetchUserByEmailAndPassword(email, password);
			}
			
			return userres;
    	
	}
    
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id){
//  	  UserResponse resp = new UserResponse();
//      try{
          return userService.getUser(id);
//          resp.setMessage("Success");
//          resp.setUsers(user);
//          return ResponseEntity.status(HttpStatus.OK).body(resp);
//      } catch (Exception e){
//          resp.setError("User with " + id + " Not Found!");
//          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
         
      
      }
    
    @PostMapping("/addFavouriteRestaurant/{userId}/{restaurantId}")
    public String addFavouriteRestaurant(@PathVariable String userId, @PathVariable String restaurantId) {
    	return userService.addToFavouriteRestaurants(userId, restaurantId);
    }
    
    @PostMapping("/removefromfav/{userId}/{restId}")
    public String removeFav(@PathVariable String userId,@PathVariable String restId) {
    	return userService.removeFav(userId,restId);
    }
    
    @GetMapping("getfavourites/{id}")
    public List<String> getfav(@PathVariable String id){
    	User user=userService.getUser(id);
    	return user.getFavouriteRestaurants();
    }
}

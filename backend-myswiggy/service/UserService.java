package com.example.myswiggy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.myswiggy.customexceptions.WrongEmailOrPasswordException;
import com.example.myswiggy.entity.User;
import com.example.myswiggy.repository.UserRepository;
import com.example.myswiggy.response.UserResponse;

@Service
public class UserService {

	@Autowired
	UserRepository userRep;
	
	public String createUser(User user){
		userRep.save(user);
		return "Data saved successfully";
	}
	
	public User getUser(String id) {
		Optional<User> user=userRep.findById(id);
		return user.get();
	}
	
	public User fetchUserByEmailAndPassword(String email,String password) {
		try
		{
			return userRep.findByEmailAndPassword(email, password);
		}
		catch(WrongEmailOrPasswordException e)
		{
			throw new WrongEmailOrPasswordException("Wrong credentials");
		}
	}

	public String addToFavouriteRestaurants(String userId, String restaurantId) {
		// TODO Auto-generated method stub
		Optional<User> user =userRep.findById(userId);
		  if (user.isPresent()) {
			    User u = user.get();
			    List<String> favoriteRestaurants = u.getFavouriteRestaurants();
			    if (!favoriteRestaurants.contains(restaurantId)) {
			      favoriteRestaurants.add(restaurantId);
			      userRep.save(u);
			      return "success";
			    } else {
			      return "favorite restaurant already exists";
			    }
			  } else {
			    return "user not found";
			  }
	}

	public String removeFav(String userId, String restId) {
		// TODO Auto-generated method stub
		Optional<User> user =userRep.findById(userId);
		  if (user.isPresent()) {
			    User u = user.get();
			    List<String> favoriteRestaurants = u.getFavouriteRestaurants();
			    if (favoriteRestaurants.contains(restId)) {
			      favoriteRestaurants.remove(restId);
			      userRep.save(u);
			      return "successfully removed from fav";
			   
			  } else {
			    return "not found found in favs";
			  }
		  }
		return "SUCCESS";}
	}

package com.example.myswiggy.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "restaurant")
public class Restaurant {
	
@Id
 public String id;
 public String name;
 public String cloudinaryImageId;
 public String locality;
 public List<String> cuisines;
 public String avgRatingString;
 public String totalRatingsString;
 
}

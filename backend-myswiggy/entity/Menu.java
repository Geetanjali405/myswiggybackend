package com.example.myswiggy.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection="menu")
public class Menu {
	
@Id
public String id;
public String name;
public String category;
public String description;
public String imageId;
public String isVeg;
public String price;
public String rating;
public String ratingCount;
public String restId;
}

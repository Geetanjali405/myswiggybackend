package com.example.myswiggy.entity;

import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection="Delivery")
@Data
public class Delivery {
	@Id
	public String id;
	public String delId;
	public Map<String, String> orderIdAndStatus= new HashMap<>();;
}

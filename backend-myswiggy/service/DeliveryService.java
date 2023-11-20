package com.example.myswiggy.service;


import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myswiggy.entity.Delivery;
import com.example.myswiggy.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	DeliveryRepository delRep;
	
	public Delivery create(Delivery delivery) {
		// TODO Auto-generated method stub
		Delivery existingDelivery = delRep.findByDelId("123");
		    if(existingDelivery != null) {
		       return existingDelivery;
		        
		    } else {
			       delivery.setDelId("123");
			        return delRep.save(delivery);
		    }
	}

	public Delivery addOrder(String orderId) {
		// TODO Auto-generated method stub
	    Delivery del = delRep.findByDelId("123");
	    if (del.getOrderIdAndStatus() == null) {
	        del.setOrderIdAndStatus(new HashMap<String, String>());
	    }
	    if (!del.getOrderIdAndStatus().containsKey(orderId)) {
	        del.getOrderIdAndStatus().put(orderId, "Order Placed");
	    } else {
	        String status = del.getOrderIdAndStatus().get(orderId);
	        if (status.equals("Order Placed")) {
	            del.getOrderIdAndStatus().put(orderId, "Processing");
	        } else if (status.equals("Processing")) {
	            del.getOrderIdAndStatus().put(orderId, "Accepted");
	        } else if (status.equals("Accepted")) {
	            del.getOrderIdAndStatus().put(orderId, "On the way");
	        }else if (status.equals("On the way")) {
	            del.getOrderIdAndStatus().put(orderId, "Delivered");
	        }
	        
	    }
		delRep.save(del);
		return del;
		
	}

	public Delivery getDeliveryby() {
		// TODO Auto-generated method stub
		System.out.println(delRep.findByDelId("123"));
		return delRep.findByDelId("123");
		
	}


	public String getOrderStatus(String orderId) {
		// TODO Auto-generated method stub
		Delivery del=delRep.findByDelId("123");
		return del.orderIdAndStatus.get(orderId);
	}


}

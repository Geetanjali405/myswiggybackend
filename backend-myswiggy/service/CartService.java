package com.example.myswiggy.service;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myswiggy.entity.Cart;
import com.example.myswiggy.repository.CartRepository;
import com.example.myswiggy.repository.MenuRepository;

@Service
public class CartService {
    @Autowired
    private  CartRepository cartRep;
    
    @Autowired
    private  MenuRepository menuRep;

	public Cart createCart(Cart cart) {
		  Cart existingCart = cartRep.findByUserId(cart.getUserId());
		    if(existingCart != null) {
		        return existingCart;
		    } else {
		        cart.setTotal(0.0);
		        cart.setDeliveryAddress("");
		        return cartRep.save(cart);
		    }
	}

	public Cart getCart(String id) {
		// TODO Auto-generated method stub
		Optional<Cart> cart= cartRep.findById(id);
		return cart.get();
	}

	public Cart getCartByUserId(String id) {
	
		Cart cart=cartRep.findByUserId(id);
		return cart;
	}

	
	public Cart addItemToCart(String userId, String prodId,String price) {
		// TODO Auto-generated method stub
	    Cart cart = getCartByUserId(userId);
	    System.out.println(price);
	    int actualPrice = Integer.parseInt(price) / 100;
	    if (cart.getItems() == null) {
	        cart.setItems(new HashMap<String, Integer>());
	        cart.setTotal(0.0);
	    }
	    
	    if (cart.getItems().containsKey(prodId)) {
	        int currentQuantity = cart.getItems().get(prodId);
	        cart.getItems().put(prodId, currentQuantity + 1);
	        cart.setTotal(cart.getTotal() + actualPrice);
	        cartRep.save(cart);
	       
	    } else {
	        cart.getItems().put(prodId, 1);
	        cart.setTotal(cart.getTotal()+actualPrice);
	        cartRep.save(cart);
	    }
	    return cart;
	    
	}

	public Cart decreaseItemInCart(String userId, String prodId, String price) {
		// TODO Auto-generated method stub
		Cart cart = getCartByUserId(userId);
		int actualPrice = Integer.parseInt(price) / 100;
		int currentQuantity = cart.getItems().get(prodId);
		if (currentQuantity == 1) {
            cart.getItems().remove(prodId);
        } else {
            cart.getItems().put(prodId, currentQuantity - 1);
        }
        
        cart.setTotal(cart.getTotal() - actualPrice);
        cartRep.save(cart);

	    return cart;
	}

	public Cart deleteItem(String userId,String prodId,String price) {
		// TODO Auto-generated method stub
		Cart cart = getCartByUserId(userId);
		int actualPrice = Integer.parseInt(price) / 100;
		int currentQuantity = cart.getItems().get(prodId);
		cart.setTotal(cart.getTotal() - actualPrice*currentQuantity);
		cart.getItems().remove(prodId);
		cartRep.save(cart);
		return cart;
		
	}

	public String deleteCart(String userId) {
		// TODO Auto-generated method stub
		Cart cart=getCartByUserId(userId);
		cartRep.delete(cart);
		return "Cart cleared successfully!!";
		
	}
	
}


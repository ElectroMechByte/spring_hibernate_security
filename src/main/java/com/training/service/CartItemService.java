package com.training.service;

import com.training.model.Cart;
import com.training.model.CartItem;

public interface CartItemService {

	void addCartItem(CartItem cartItem);

	void removeCartItem(String CartItemId);

	void removeAllCartItems(Cart cart);
	
}

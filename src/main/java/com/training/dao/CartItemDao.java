package com.training.dao;

import com.training.model.Cart;
import com.training.model.CartItem;

public interface CartItemDao {

	void addCartItem(CartItem cartItem);

	void removeCartItem(String CartItemId);

	void removeAllCartItems(Cart cart);
}

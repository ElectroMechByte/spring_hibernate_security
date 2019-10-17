package com.training.service;

import java.io.IOException;

import com.training.model.Cart;

public interface CartService {

	Cart getCartByCartId(String CartId);

	Cart validate(String cartId) throws IOException;

	void update(Cart cart);
}

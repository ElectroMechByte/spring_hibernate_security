package com.training.dao;

import java.io.IOException;

import com.training.model.Cart;

public interface CartDao {

	Cart getCartByCartId(String CartId);

	Cart validate(String cartId) throws IOException;

	void update(Cart cart);
}

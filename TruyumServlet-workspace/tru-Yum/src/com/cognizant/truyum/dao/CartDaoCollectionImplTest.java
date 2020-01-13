package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {
	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(2, 3L);
		cartDao.addCartItem(2, 1L);
		cartDao.addCartItem(2, 5L);
		System.out.println("User Added Cart List for Checkout");
		Cart cart = cartDao.getAllCartItems(2);
		for (MenuItem menuItem : cart.getMenuItemList()) {
			System.out.println(menuItem);
		}
	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for Customer after Remove");
		try {
			cartDao.removeCartItem(2, 3L);
			cartDao.removeCartItem(2, 1L);
			Cart cart = cartDao.getAllCartItems(2);

			for (MenuItem menuItem : cart.getMenuItemList()) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllCartItems() {

	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
	}

}
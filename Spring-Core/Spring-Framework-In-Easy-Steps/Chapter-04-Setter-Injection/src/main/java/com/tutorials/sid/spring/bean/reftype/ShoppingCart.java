/**
 * 
 */
package com.tutorials.sid.spring.bean.reftype;

/**
 * @author Lenovo
 *
 */
public class ShoppingCart {
	private String cartName;
	private Item item;

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "ShoppingCart [cartName=" + cartName + ", item=" + item + "]";
	}

}

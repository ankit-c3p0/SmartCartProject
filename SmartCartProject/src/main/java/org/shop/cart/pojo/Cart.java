package org.shop.cart.pojo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class Cart {

	private String itemID;
	private String itemCategoryID;
	private String itemName;
	private Double unitPrice;
	private Integer quantity;

	
	public Cart(String itemID, String itemCategoryID, String itemName, Double unitPrice, Integer quantity) {

		this.itemID = itemID;
		this.itemCategoryID = itemCategoryID;
		this.itemName = itemName;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public String getItemCategoryID() {
		return itemCategoryID;
	}

	public void setItemCategoryID(String itemCategoryID) {
		this.itemCategoryID = itemCategoryID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
	
}

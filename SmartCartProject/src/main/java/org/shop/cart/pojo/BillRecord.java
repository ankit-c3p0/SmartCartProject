package org.shop.cart.pojo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class BillRecord {

	private String itemName;
	private Integer quantity;
	private Double unitPrice;
	private Double discount;
	private Double netPurchareAmt;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getNetPurchareAmt() {
		return netPurchareAmt;
	}
	public void setNetPurchareAmt(Double netPurchareAmt) {
		this.netPurchareAmt = netPurchareAmt;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

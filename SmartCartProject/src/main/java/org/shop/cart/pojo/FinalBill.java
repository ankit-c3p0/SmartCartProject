package org.shop.cart.pojo;

import java.util.List;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class FinalBill {

	private List<BillRecord> items;
	private Double grandTotal;
	private Double applicableDiscount;
	private Double netBillAmount;

	public List<BillRecord> getItems() {
		return items;
	}
	public void setItems(List<BillRecord> items) {
		this.items = items;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Double getApplicableDiscount() {
		return applicableDiscount;
	}
	public void setApplicableDiscount(Double applicableDiscount) {
		this.applicableDiscount = applicableDiscount;
	}
	public Double getNetBillAmount() {
		return netBillAmount;
	}
	public void setNetBillAmount(Double netBillAmount) {
		this.netBillAmount = netBillAmount;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}

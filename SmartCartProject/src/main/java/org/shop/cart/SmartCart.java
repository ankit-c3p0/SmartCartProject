package org.shop.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.shop.cart.pojo.BillRecord;
import org.shop.cart.pojo.Cart;
import org.shop.cart.pojo.FinalBill;

import java.util.TreeSet;

public class SmartCart {

	public FinalBill generateFinalBill(Map<String, Double> categoryDiscountMap, Map<Double, Double> finalDiscountSlab,
			Map<String, Object> cartMap) {

		// calculate itemized bill for cart items and set net purchase amount for each items.
		FinalBill bill = new FinalBill();
		List<BillRecord> billItems = applyDiscountByCategory(categoryDiscountMap, cartMap);
		
		double grandTotal = 0.0;
		if(billItems != null) {
			for(BillRecord item : billItems) {
				grandTotal += item.getNetPurchareAmt();
			}
		} else {
			System.out.println("Cart is Empty....");
			return null;
		}
		bill.setItems(billItems);
		bill.setGrandTotal(grandTotal);
		System.out.println("Grand Total: " + grandTotal);
		
		//get applicable discount and calculated the discounted price.
		double applicableDiscount = getFinalDiscountForGrandTotal(finalDiscountSlab, grandTotal);
		bill.setApplicableDiscount(applicableDiscount);
		System.out.println("Applicable Discount for the bill: " + applicableDiscount);
		
		bill.setNetBillAmount(grandTotal-(applicableDiscount/100)*grandTotal);
		System.out.println("Generated Final bill: " + bill.getNetBillAmount());
		
		return bill;
	}

	/*
	 * This method is responsible for applying discount by category
	 * and calculating net purchase amount for each item.
	 */
	public List<BillRecord> applyDiscountByCategory(Map<String, Double> categoryDiscountMap, Map<String, Object> cartMap) {

		List<BillRecord> billRecs = new ArrayList<>();
		BillRecord billRec = null;
		Cart _cart = null;
		for (String cartKey : cartMap.keySet()) {

			_cart = (Cart) cartMap.get(cartKey);
			billRec = new BillRecord();
			billRec.setItemName(_cart.getItemName());
			double netWorth = _cart.getQuantity() * _cart.getUnitPrice();
			double itemDiscount = _cart.getQuantity() * _cart.getUnitPrice()* (categoryDiscountMap.get(_cart.getItemCategoryID())/100);
			billRec.setNetPurchareAmt(netWorth-itemDiscount);
			billRecs.add(billRec);
		}
		return billRecs;
	}

	/*
	 * This method returns the applicable discount applicable for the calculated grand total.
	 */
	public Double getFinalDiscountForGrandTotal(Map<Double, Double> finalDiscountSlab, Double grandTotal) {

		TreeSet<Double> set = new TreeSet<>();
		for (Entry<Double, Double> slabEntry : finalDiscountSlab.entrySet()) {
			set.add(slabEntry.getKey());
		}
		double applicableDiscount = finalDiscountSlab.get(set.ceiling(grandTotal));
		System.out.println("Applicable final discount: " + applicableDiscount);
		return applicableDiscount;
	}
}

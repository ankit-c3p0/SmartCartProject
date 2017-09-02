package org.shop.cart;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.shop.cart.SmartCart;
import org.shop.cart.pojo.BillRecord;
import org.shop.cart.pojo.Cart;
import org.shop.cart.pojo.Category;
import org.shop.cart.pojo.DiscountSlab;
import org.shop.cart.pojo.FinalBill;

public class TestSmartCart {

	private static SmartCart _smartCart;

	@BeforeClass
	public static void initObject() {
		_smartCart = new SmartCart();
	}

	@Test
	public void testGetFinalDiscountGrandTotal() {

		Map<Double, Double> discountSlab = new HashMap<>();
		discountSlab.put(3000.0, 2.0);
		discountSlab.put(7000.0, 4.0);
		discountSlab.put(Double.MAX_VALUE, 5.0);

		double appDisc = _smartCart.getFinalDiscountForGrandTotal(discountSlab, 5000.0);
		assertEquals(appDisc, 4.0, 0.0);
	}

	@Test
	public void testApplyDiscountByCategory() {

		List<BillRecord> billItems = _smartCart.applyDiscountByCategory(getCategoryDiscountMapForTest(),
				getCartDataForTest());

		List<Double> actualNetPurchaselist = new ArrayList<>();
		List<Double> expectedNetPurchaselist = getExpectedNetPurchase();

		for (BillRecord items : billItems) {
			actualNetPurchaselist.add(items.getNetPurchareAmt());
		}

		Object[] expectedNetPurchase = expectedNetPurchaselist.toArray();
		Object[] actualNetPurchase = actualNetPurchaselist.toArray();

		assertArrayEquals(expectedNetPurchase, actualNetPurchase);

	}

	@Test
	public void testGenerateFinalBill() {

		FinalBill bill = _smartCart.generateFinalBill(getCategoryDiscountMapForTest(),
				testGetFinalDiscountSlabForTest(), getCartDataForTest());
		
		double expectedGrandTotal = 1501.6;
		double expectedApplicableDiscount = 2.0;
		double expectedNetBillAmount = 1471.568;
		
		assertEquals(expectedGrandTotal, bill.getGrandTotal(), 0.0);
		assertEquals(expectedApplicableDiscount, bill.getApplicableDiscount(), 0.0);
		assertEquals(expectedNetBillAmount, bill.getNetBillAmount(), 0.000);
		
	}

	public List<Double> getExpectedNetPurchase() {
		List<Double> actualNetPurchaselist = new ArrayList<>();
		actualNetPurchaselist.add(1305.6);
		actualNetPurchaselist.add(196.0);
		return actualNetPurchaselist;
	}

	public Map<Double, Double> testGetFinalDiscountSlabForTest() {

		Map<Double, Double> finalDiscountSlab = new HashMap<>();

		DiscountSlab slab = new DiscountSlab(0.0, 3000.0, 2.0);
		finalDiscountSlab.put(slab.getRangeMax(), slab.getDiscPerc());
		slab = new DiscountSlab(3001.0, 7000.0, 4.0);
		finalDiscountSlab.put(slab.getRangeMax(), slab.getDiscPerc());
		slab = new DiscountSlab(7000.0, Double.MAX_VALUE, 5.0);
		finalDiscountSlab.put(slab.getRangeMax(), slab.getDiscPerc());

		return finalDiscountSlab;
	}

	public Map<String, Object> getCartDataForTest() {

		Map<String, Object> cartMap = new HashMap<>();

		Cart _cart = new Cart("000001", "003", "Muesli", 100.0, 2);
		cartMap.put(_cart.getItemID(), _cart);

		_cart = new Cart("000002", "005", "Mens Tshirt Arrow 3463", 1536.0, 1);
		cartMap.put(_cart.getItemID(), _cart);

		return cartMap;
	}

	public Map<String, Double> getCategoryDiscountMapForTest() {

		Map<String, Double> categoryDiscountMap = new HashMap<>();

		Category _category = new Category("001", "ConsumerGoods", 5.0);
		categoryDiscountMap.put(_category.getId(), _category.getDiscPerc());

		_category = new Category("002", "OrganicFood", 7.0);
		categoryDiscountMap.put(_category.getId(), _category.getDiscPerc());

		_category = new Category("003", "Grocery", 2.0);
		categoryDiscountMap.put(_category.getId(), _category.getDiscPerc());

		_category = new Category("004", "BabyProducts", 10.0);
		categoryDiscountMap.put(_category.getId(), _category.getDiscPerc());

		_category = new Category("005", "Apparrel", 15.0);
		categoryDiscountMap.put(_category.getId(), _category.getDiscPerc());
		return categoryDiscountMap;
	}
}

/*
-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running org.shop.cart.TestSmartCart
Applicable final discount: 4.0
Grand Total: 1501.6
Applicable final discount: 2.0
Applicable Discount for the bill: 2.0
Generated Final bill: 1471.568
Tests run: 3, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.005 sec

Results :

Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
 */

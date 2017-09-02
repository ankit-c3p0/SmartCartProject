package org.shop.cart.pojo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class DiscountSlab {

	private Double rangeMin;
	private Double rangeMax;
	private Double discPerc;

	public DiscountSlab(Double rangeMin, Double rangeMax, Double discPerc) {

		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.discPerc = discPerc;
	}

	public Double getRangeMin() {
		return rangeMin;
	}

	public void setRangeMin(Double rangeMin) {
		this.rangeMin = rangeMin;
	}

	public Double getRangeMax() {
		return rangeMax;
	}

	public void setRangeMax(Double rangeMax) {
		this.rangeMax = rangeMax;
	}

	public Double getDiscPerc() {
		return discPerc;
	}

	public void setDiscPerc(Double discPerc) {
		this.discPerc = discPerc;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}

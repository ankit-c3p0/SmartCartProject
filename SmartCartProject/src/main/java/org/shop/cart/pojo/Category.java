package org.shop.cart.pojo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Category {

	@JacksonXmlProperty(localName = "id")
	private String id;
	@JacksonXmlProperty(localName = "name")
	private String name;
	@JacksonXmlProperty(localName = "discPerc")
	private Double discPerc;

	public Category(String id, String name, Double discPerc) {

		this.id = id;
		this.name = name;
		this.discPerc = discPerc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

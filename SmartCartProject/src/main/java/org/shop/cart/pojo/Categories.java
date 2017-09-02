package org.shop.cart.pojo;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Categories")
public class Categories {
	
	@JacksonXmlElementWrapper(useWrapping = false)
	private Category[] categories;

	public Categories() {

	}
	
	public Category[] getCategories() {
		return categories;
	}

	public void setCategories(Category[] categories) {
		this.categories = categories;
	}
	
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

	
}

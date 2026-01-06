package com.example.product_supplier_jdbc;

import java.math.BigDecimal;

public class Product {
	private long productId;
	private String productName;
	private BigDecimal price;
	private long supplierId;
	
	public Product(long productId, String productName, BigDecimal price, long supplierId) {
		this.productId =productId;
		this.productName =productName;
		this.price = price;
		this.supplierId = supplierId;
	}

	public long getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public long getSupplierId() {
		return supplierId;
	}

	@Override
	public String toString() {
		return "Product{id=%d, name='%s', price=%f, supplierId=%d}".formatted(
				productId,productName,price,supplierId);
	}
	
}

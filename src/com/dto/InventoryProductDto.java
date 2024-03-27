package com.dto;

import java.time.LocalDate;

public class InventoryProductDto {
	private int productId;
	private String productName;
	private double productPrice;
	private int quantityInStock;
	private LocalDate lastStockUpdate;

	public InventoryProductDto(int productId, String productName, double productPrice, int quantityInStock,
			LocalDate lastStockUpdate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantityInStock = quantityInStock;
		this.lastStockUpdate = lastStockUpdate;
	}

	public InventoryProductDto() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getQuantityInStock() {
		return quantityInStock;
	}

	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}

	public LocalDate getLastStockUpdate() {
		return lastStockUpdate;
	}

	public void setLastStockUpdate(LocalDate lastStockUpdate) {
		this.lastStockUpdate = lastStockUpdate;
	}

	@Override
	public String toString() {
		return "InventoryProductDto [productId=" + productId + ", productName=" + productName + ", productPrice="
				+ productPrice + ", quantityInStock=" + quantityInStock + ", lastStockUpdate=" + lastStockUpdate + "]";
	}

}

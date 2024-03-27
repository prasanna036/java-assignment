package com.dto;

public class TotalInventoryValueDto {
private String productName;
private double totalValue;
public TotalInventoryValueDto() {
	super();
}
public TotalInventoryValueDto(String productName, double totalValue) {
	super();
	this.productName = productName;
	this.totalValue = totalValue;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
@Override
public String toString() {
	return "TotalInventoryValueDto [productName=" + productName + ", totalValue=" + totalValue + "]";
}
public double getTotalValue() {
	return totalValue;
}
public void setTotalValue(double totalValue) {
	this.totalValue = totalValue;
}

}

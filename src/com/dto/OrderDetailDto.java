package com.dto;

public class OrderDetailDto {

	private int customer_id;
	private int total_amount;
	private int quantity;
	public OrderDetailDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailDto(int customer_id, int total_amount, int quantity) {
		super();
		this.customer_id = customer_id;
		this.total_amount = total_amount;
		this.quantity = quantity;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderDetailDto [customer_id=" + customer_id + ", total_amount=" + total_amount + ", quantity="
				+ quantity + "]";
	}
	
}

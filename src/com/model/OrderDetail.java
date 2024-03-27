package com.model;

public class OrderDetail {

	private int id;
	private int quantity;
	private int orders_id;
	private int product_id;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int id, int quantity, int orders_id, int product_id) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.orders_id = orders_id;
		this.product_id = product_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getOrders_id() {
		return orders_id;
	}
	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", quantity=" + quantity + ", orders_id=" + orders_id + ", product_id="
				+ product_id + "]";
	}
	
	
}

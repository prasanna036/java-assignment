package com.model;

public class Order {
private int id;
private String order_date;
private int total_amount;
private int customer_id;
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(int id, String order_date, int total_amount, int customer_id) {
	super();
	this.id = id;
	this.order_date = order_date;
	this.total_amount = total_amount;
	this.customer_id = customer_id;
}
public Order(String order_date, int total_amount, int customer_id) {
	super();
	this.order_date = order_date;
	this.total_amount = total_amount;
	this.customer_id = customer_id;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getOrder_date() {
	return order_date;
}
public void setOrder_date(String order_date) {
	this.order_date = order_date;
}
public int getTotal_amount() {
	return total_amount;
}
public void setTotal_amount(int total_amount) {
	this.total_amount = total_amount;
}
public int getCustomer_id() {
	return customer_id;
}
public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}
@Override
public String toString() {
	return "Order [id=" + id + ", order_date=" + order_date + ", total_amount=" + total_amount + ", customer_id="
			+ customer_id + "]";
}

}

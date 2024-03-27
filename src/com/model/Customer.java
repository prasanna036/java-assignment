package com.model;

public class Customer {
private int id;
private String firstName;
private String lastName;
private String email;
private String phone;
private String address;
private int total_no_order;
private String name;

public Customer() {
	super();
	// TODO Auto-generated constructor stub
}
public Customer(int id, String firstName, String lastName, String email, String phone, String address) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.address = address;
}
public Customer(String firstName, String lastName, String email, String phone, String address) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.address = address;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Customer(int total_no_order,String name) {
    // Other fields...
	super();
	this.total_no_order=total_no_order;
	this.name =name;

}

public int getTotal_no_order() {
	return total_no_order;
}
public void setTotal_no_order(int total_no_order) {
	this.total_no_order = total_no_order;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", phone=" + phone + ", address=" + address + "]";
}

}
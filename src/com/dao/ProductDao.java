package com.dao;

import java.sql.SQLException;
import java.util.List;

import com.exception.InventoryDetailsNotFound;
import com.model.Inventory;
import com.model.Product;
import com.service.*;
public interface ProductDao {

	public List<Product> getProductDetails() throws SQLException;

	public void updateProduct(int id, String name, String description, int price) throws SQLException;

	public Inventory getInventoryDetails(int pid1) throws SQLException, InventoryDetailsNotFound;
		
}

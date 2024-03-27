package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.*;
import com.model.Inventory;
import com.model.Product;
import com.exception.*;
public class ProductService {
	ProductDao productDao=new ProductDaoImpl();

	public List<Product> getProductDetails() throws SQLException{
		return productDao.getProductDetails();
		
	}

	public void updateProduct(int id, String name, String description, int price)throws SQLException {
		// TODO Auto-generated method stub
		productDao.updateProduct(id,name,description,price);
	}

	public boolean checkAvailability(Inventory i, int pid1) {
		if(i.getId()==pid1) {
			if(i.getQuantityInStock()>0) {
				return true;
			}
		}
		return false;
	}
	public Inventory getInventoryDetails(int pid1) throws SQLException,InventoryDetailsNotFound {
		return productDao.getInventoryDetails(pid1);
	}



}

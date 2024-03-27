package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.service.*;
import com.model.Customer;
import com.exception.InventoryDetailsNotFound;
import com.model.*;
import com.exception.*;
import com.util.DBUtil;
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> getProductDetails() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getDBConn();
		List<Product> list = new ArrayList<>();
		String sql = "select * from product";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id=rst.getInt("id");
			String name = rst.getString("name");
			String description=rst.getString("description");
			int price = rst.getInt("price");
			
			Product p=new Product();
			p.setId(id);
			p.setName(name);
			p.setDescription(description);
			p.setPrice(price);
			list.add(p);

		}

		DBUtil.dbClose();
		return list;
	}

	@Override
	public void updateProduct(int id, String name, String description, int price) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		
		String sql="update product set name = ?,description =?,price=? where id =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, description);
		pstmt.setInt(3, price);
		pstmt.setInt(4, id);
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}
	@Override
	public Inventory getInventoryDetails(int pid1) throws SQLException, InventoryDetailsNotFound {
		Connection conn=DBUtil.getDBConn();
		String sql="select * from inventory where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pid1);
		ResultSet rst =pstmt.executeQuery();
		if (rst.next()) {
			int productId=rst.getInt("product_id");
			int quantityInStock=rst.getInt("quantity_in_stock");
			Inventory i=new Inventory();
			i.setProductId(productId);
			i.setQuantityInStock(quantityInStock);
			return i;
		}
		
		
		DBUtil.dbClose();
		throw new InventoryDetailsNotFound("Item out of stock");
		
		
		
	}


}

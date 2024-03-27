package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.exception.*;
import com.util.DBUtil;
import com.model.*;
public class CustomerDaoImpl implements CustomerDao {

	
	@Override
	public List<Customer> getCustomerDetails() throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getDBConn();
		List<Customer> list = new ArrayList<>();
		String sql = "select * from customer";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int id=rst.getInt("id");
			String firstName = rst.getString("first_name");
			String lastName=rst.getString("last_name");
			String email = rst.getString("email");
			String phone=rst.getString("phone");
			String address=rst.getString("address");
			Customer c=new Customer();
			c.setId(id);
			c.setFirstName(firstName);
			c.setLastName(lastName);
			c.setPhone(phone);
			c.setEmail(email);
			c.setAddress(address);
			list.add(c);

		}

		DBUtil.dbClose();
		return list;
	}
	@Override
	public void updateCustomer(int id,String email, String phone, String address) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=DBUtil.getDBConn();
		
		String sql="update customer set email = ?,phone =?,address=? where id =?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
		pstmt.setString(1, email);
		pstmt.setString(2, phone);
		pstmt.setString(3, address);
		pstmt.setInt(4, id);
		pstmt.executeUpdate();
		DBUtil.dbClose();
	}
	public List<Order> calculateTotalOrders(int id) throws SQLException {
		Connection conn=DBUtil.getDBConn();
		List<Order> list=new ArrayList<Order>();
		String sql="select * from orders where customer_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();
		while (rst.next()) {
			int oid =rst.getInt("id");
			Order o=new Order();
			o.setId(oid);
			list.add(o);
			
		}
		
		DBUtil.dbClose();
		return list;

	}
	public Customer validateCustomer(int id) throws SQLException, CustomerNotFoundException {
		Connection conn=DBUtil.getDBConn();
		Customer c =new Customer();
		String sql="select * from customer where id=?";
		PreparedStatement pstmt= conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst =pstmt.executeQuery();
		if (rst.next()) {
			int cid=rst.getInt("id");
			c.setId(cid);
			return c;
		}
		DBUtil.dbClose();
		
		throw new CustomerNotFoundException("Customer ID Invalid");
	}

}


package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit2016.bookmall.vo.Customer;

public class CustomerDAO {

	public static void insert(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into customer values(CUSTOMER_SEQ.nextval, ?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getName());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getPassword());

			stmt.executeUpdate();//
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update customer set name=?, number=?,email=?,password=? where customer_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, customer.getName());
			stmt.setString(2, customer.getNum());
			stmt.setString(3, customer.getEmail());
			stmt.setString(4, customer.getPassword());
			stmt.setLong(5, customer.getCustomer_no());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(Customer customer) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete from customer where customer_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, customer.getCustomer_no());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static ArrayList<Customer> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			conn = DAOConnection.connection();

			String sql = "select name,num,email,password from customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setName(rs.getString(1));
				customer.setNum(rs.getString(2));
				customer.setEmail(rs.getString(3));
				customer.setPassword(rs.getString(4));
				customerList.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error:" + e);
		} finally {
			// 3. 자원 관리
			try {
				if (conn != null) {
					conn.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customerList;
	}
}

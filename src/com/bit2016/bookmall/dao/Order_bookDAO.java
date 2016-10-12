package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit2016.bookmall.vo.Customer;
import com.bit2016.bookmall.vo.Order_book;

public class Order_bookDAO {

	public static void insert(Order_book order_book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into order_book values(?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, order_book.getBook_no());
			stmt.setLong(2, order_book.getOrder_no());
			stmt.setLong(3, order_book.getQuantity());
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

	public static void update(Order_book order_book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update order_book set quantity=? where book_no=? and order_no=?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, order_book.getBook_no());
			stmt.setLong(2, order_book.getOrder_no());
			stmt.setLong(3, order_book.getQuantity());
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

	public static void delete(Order_book order_book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete from order_book where book_no=? and order_no=?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, order_book.getBook_no());
			stmt.setLong(2, order_book.getOrder_no());
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

			String sql = "select name,number,email,password from customer";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {

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

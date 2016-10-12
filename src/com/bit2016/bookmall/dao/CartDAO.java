package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit2016.bookmall.vo.Cart;

public class CartDAO {
	public static void insert(Cart cart) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into cart values(?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, cart.getBook_no());
			stmt.setLong(2, cart.getCustomer_no());
			stmt.setLong(3, cart.getQuantity());
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

	public static void update(Cart cart) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update cart set quantity where book_no =? AND customer_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, cart.getBook_no());
			stmt.setLong(2, cart.getCustomer_no());
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

	public static void delete(Cart cart) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete from cart where book_no =? AND customer_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, cart.getBook_no());
			stmt.setLong(2, cart.getCustomer_no());
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

	public static ArrayList<Cart> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		try {
			conn = DAOConnection.connection();

			// 3. statement 객체 생성
			// 4. sql문 실행
			String sql = "SELECT * FROM cart";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Cart cart = new Cart();
				cart.setBook_no(rs.getLong(1));
				cart.setCustomer_no(rs.getLong(2));
				cart.setQuantity(rs.getLong(3));
				cartList.add(cart);
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
		return cartList;
	}
}

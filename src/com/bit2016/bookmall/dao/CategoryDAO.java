package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit2016.bookmall.vo.Book;
import com.bit2016.bookmall.vo.Category;

public class CategoryDAO {
	public static void insert(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into category values(CATEGORY_SEQ.nextval, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, category.getName());

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

	public static void update(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update category set name=? where category_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, category.getName());
			stmt.setLong(2, category.getCategory_no());
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

	public static void delete(Category category) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete from category where category_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, category.getCategory_no());
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

	public static ArrayList<Category> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Category> categoryList = new ArrayList<Category>();
		try {
			conn = DAOConnection.connection();

			// 3. statement 객체 생성
			// 4. sql문 실행
			String sql = "SELECT * FROM category";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Category category = new Category();
				category.setCategory_no(rs.getLong(1));
				category.setName(rs.getString(2));
				categoryList.add(category);
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
		return categoryList;
	}
}

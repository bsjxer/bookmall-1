package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit2016.bookmall.vo.Book;

public class BookDAO {

	public static void insert(Book book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "insert into book values(book_seq.nextval, ?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setLong(2, book.getPrice());
			stmt.setLong(3, book.getCategory_no());

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

	public static void update(Book book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "update book set tilte=?, price=?,category_no=? where book_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, book.getTitle());
			stmt.setLong(2, book.getPrice());
			stmt.setLong(3, book.getCategory_no());
			stmt.setLong(4, book.getBook_no());
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

	public static void delete(Book book) {
		Connection conn = null;
		PreparedStatement stmt = null;

		try {
			conn = DAOConnection.connection();

			String sql = "delete from book where book_no =?";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, book.getBook_no());
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

	public static ArrayList<Book> select() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		try {
			conn = DAOConnection.connection();

			String sql = "SELECT b.*, c.NAME " + "FROM book b INNER JOIN "
					+ "category c ON b.CATEGORY_NO = c.CATEGORY_NO";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Book book = new Book();
				book.setBook_no(rs.getLong(1));
				book.setTitle(rs.getString(2));
				book.setPrice(rs.getLong(3));
				book.setCategory_no(rs.getLong(4));
				book.setCategory_name(rs.getString(5));//category_name
				bookList.add(book);
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
		return bookList;
	}
}

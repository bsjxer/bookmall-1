package com.bit2016.bookmall.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.bit2016.bookmall.dao.BookDAO;
import com.bit2016.bookmall.vo.Book;

public class BookTest {

	public static void main(String[] args) {
		Book book = null;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.book 삽입, 2.book 삭제, 3.book 수정, 4. book 보기");
			int index = sc.nextInt();
			switch (index) {
			case 1:
				book = new Book();
				System.out.println("book title");
				String title = sc.next();
				book.setTitle(title);
				System.out.println("book price");
				Long price = sc.nextLong();
				book.setPrice(price);
				System.out.println("book category");
				Long category = sc.nextLong();
				book.setCategory_no(category);
				getInsert(book);
				break;
			case 2:
				book = new Book();
				System.out.println("book no");
				Long no = sc.nextLong();
				book.setBook_no(no);
				getDelete(book);
				break;
			case 3:
				book = new Book();
				System.out.println("book no");
				no = sc.nextLong();
				System.out.println("book title");
				title = sc.next();
				book.setTitle(title);
				System.out.println("book price");
				price = sc.nextLong();
				book.setPrice(price);
				System.out.println("book category");
				category = sc.nextLong();
				book.setCategory_no(category);
				getUpdate(book);
				break;
			case 4:
				getList();
				break;
			default:
				break;

			}

		}

	}

	public static void getInsert(Book book) {
		BookDAO.insert(book);

	}

	public static void getList() {
		ArrayList list = BookDAO.select();
		Iterator<Book> it = list.iterator();
		Book book;

		while (it.hasNext()) {
			book = it.next();
			System.out.println(
					book.getBook_no() + " " + book.getTitle() + " " + book.getPrice() + " " + book.getCategory_name());
		}
	}

	public static void getDelete(Book book) {
		BookDAO.delete(book);
	}

	public static void getUpdate(Book book) {
		BookDAO.update(book);
	}
}

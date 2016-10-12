package com.bit2016.bookmall.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.bit2016.bookmall.dao.CategoryDAO;
import com.bit2016.bookmall.vo.Category;

public class CategoryTest {
	public static void main(String[] args) {
		Category category = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.category 삽입, 2.category 삭제, 3.category 수정, 4. category 보기");
			int index = sc.nextInt();
			switch (index) {
			case 1:
				category = new Category();
				System.out.println("category name");
				String name = sc.next();
				category.setName(name);
				getInsert(category);
				break;
			case 2:
				category = new Category();
				System.out.println("category no");
				Long no = sc.nextLong();
				category.setCategory_no(no);
				getDelete(category);
				break;
			case 3:
				category = new Category();
				System.out.println("category no");
				no = sc.nextLong();
				System.out.println("category name");
				name = sc.next();
				category.setName(name);
				getUpdate(category);
				break;
			case 4:
				getList();
				break;
			default:
				break;

			}

		}

	}

	public static void getInsert(Category category) {
		CategoryDAO.insert(category);

	}

	public static void getList() {
		ArrayList<Category> list = CategoryDAO.select();
		Iterator<Category> it = list.iterator();
		Category category;
		while (it.hasNext()) {
			category = it.next();
			System.out.println(category.getCategory_no() + " " + category.getName());
		}
	}

	public static void getDelete(Category category) {
		CategoryDAO.delete(category);
	}

	public static void getUpdate(Category category) {
		CategoryDAO.update(category);
	}
}

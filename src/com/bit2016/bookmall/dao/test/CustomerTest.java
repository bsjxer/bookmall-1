package com.bit2016.bookmall.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.bit2016.bookmall.dao.BookDAO;
import com.bit2016.bookmall.dao.CustomerDAO;
import com.bit2016.bookmall.vo.Customer;

public class CustomerTest {

	public static void main(String[] args) {
		Customer customer = null;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1.customer 삽입, 2.customer 삭제, 3.customer 수정, 4. customer 보기");
			int index = sc.nextInt();
			switch (index) {
			case 1:
				customer = new Customer();
				System.out.println("customer name");
				String name = sc.next();
				customer.setName(name);
				System.out.println("customer password");
				String password = sc.next();
				customer.setPassword(password);
				System.out.println("customer phone number");
				String number = sc.next();
				customer.setNum(number);
				System.out.println("customer email");
				String email = sc.next();
				customer.setEmail(email);
				getInsert(customer);
				break;
			case 2:
				customer = new Customer();
				System.out.println("customer no");
				Long no = sc.nextLong();
				customer.setCustomer_no(no);
				getDelete(customer);
				break;
			case 3:
				customer = new Customer();
				System.out.println("customer no");
				no = sc.nextLong();
				customer.setCustomer_no(no);
				System.out.println("customer name");
				name = sc.next();
				customer.setName(name);
				System.out.println("customer phone number");
				number = sc.next();
				customer.setNum(number);
				System.out.println("customer email");
				email = sc.next();
				customer.setEmail(email);
				getUpdate(customer);
				break;
			case 4:
				getList();
				break;
			default:
				break;

			}

		}

	}

	public static void getInsert(Customer customer) {
		CustomerDAO.insert(customer);

	}

	public static void getList() {
		ArrayList list = CustomerDAO.select();
		Iterator<Customer> it = list.iterator();
		Customer customer;

		while (it.hasNext()) {
			customer = it.next();
			System.out.println(customer.getName() + " " + customer.getEmail() + " " + customer.getNum() + " "
					+ customer.getPassword());
		}
	}

	public static void getDelete(Customer customer) {
		CustomerDAO.delete(customer);
	}

	public static void getUpdate(Customer customer) {
		CustomerDAO.update(customer);
	}

}

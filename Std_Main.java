package com.test;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Std_Main {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

		// insert data into database
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of details");
		int no = sc.nextInt();
		
		for(int a=1; a<=no; a++) {
			
	    System.out.println("Enter name");
	    String name = sc.next();
	    
	    System.out.println("Enter city");
	    String city = sc.next();
	    
	    System.out.println("Enter mobile number");
	    String mobile = sc.next();
	    
		Student student = new Student();
		student.setName(name);
		student.setCity(city);
		student.setMobile(mobile);
		
		session.save(student);
		}
		t.commit();
		session.close();
		System.out.println("Record saved successfully.");


	}

}

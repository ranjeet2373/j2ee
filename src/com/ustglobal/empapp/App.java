package com.ustglobal.empapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.ustglobal.empapp.dao.EmployeeDAOImpl;
import com.ustglobal.empapp.dao.EmployeeDao;
import com.ustglobal.empapp.dto.EmployeeBean;
import com.ustglobal.empapp.util.EmployeeManagerFactory;

public class App {

	public static void main(String[] args) {

		System.out.println("press 1 to get all employee data");
		System.out.println("press 2 to insert all employee data");
		System.out.println("press 3 to update all employee data");
		System.out.println("press 4 to delete all employee data");
		System.out.println("press 5 to search all employee data");

		Scanner sc = new Scanner(System.in);
		int ch = sc.nextInt();

		switch(ch) {
		case 1:
			EmployeeDao dao = EmployeeManagerFactory.getEmployeeDAO();
			List<EmployeeBean> result =  dao.getAllEmployeeData();

			for (EmployeeBean bean : result) {

				System.out.println("Id is "+bean.getId());
				System.out.println("Name is "+bean.getName());
				System.out.println("Gender is "+bean.getGender());
				System.out.println("Salary is "+bean.getSal());
				System.out.println("==================");

			}
			break;
		case 2:
			EmployeeDao dao2 = EmployeeManagerFactory.getEmployeeDAO();
			EmployeeBean bean = new EmployeeBean();
			System.out.println("Enter ur id!!!");
			int id = sc.nextInt();
			bean.setId(id);

			System.out.println("Enter ur name!!");
			String name = sc.next();
			bean.setName(name);

			System.out.println("Enter ur salary!!");
			int sal =sc.nextInt();
			bean.setSal(sal);

			System.out.println("Enter ur gender!!!");
			String gender = sc.next();
			bean.setGender(gender);

			int count = dao2.insertEmployeeData(bean);
			System.out.println(count +" Rows effected!!");
			break;
		case 3:
			EmployeeDao dao3 = EmployeeManagerFactory.getEmployeeDAO();
			EmployeeBean bean3 = new EmployeeBean();
			System.out.println("Enter id which u want to update!!!");
			int id3 = sc.nextInt();
			bean3.setId(id3);

			System.out.println("Enter name!!!");
			String name3 = sc.next();
			bean3.setName(name3);

			System.out.println("Enter update salary!!!");
			int sal3 = sc.nextInt();
			bean3.setSal(sal3);

			System.out.println("Enter update gender!!!");
			String gender3 = sc.next();
			bean3.setGender(gender3);

			int count3 = dao3.updateEmployeeBeanData(bean3);
			System.out.println(count3 +" rows affected" );
			break;
		case 4:
			EmployeeDao dao4 = EmployeeManagerFactory.getEmployeeDAO();
			EmployeeBean bean4 = new EmployeeBean();
			System.out.println("Enter which record which u want to delete!!!");
			int id4 = sc.nextInt();
			bean4.setId(id4);
			int count4 = dao4.deleteEmployeeData(id4);
			System.out.println(count4 +" Rows affected!!");
			
			break;
		case 5:
			EmployeeDao dao5 = EmployeeManagerFactory.getEmployeeDAO();
			System.out.println("Enter id to fetch the data");
			int id1 = sc.nextInt();
			EmployeeBean bean1 = dao5.searchEmployeeData(id1);
			if(bean1!=null) {
				System.out.println("Id is "+bean1.getId());
				System.out.println("Name is "+bean1.getName());
				System.out.println("Gender is "+bean1.getGender());
				System.out.println("Salary is "+bean1.getSal());

			}
			else {
				System.out.println("No data found");
			}

		}


	}

}

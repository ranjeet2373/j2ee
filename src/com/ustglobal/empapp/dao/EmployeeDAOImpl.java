package com.ustglobal.empapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ustglobal.empapp.dto.EmployeeBean;

public class EmployeeDAOImpl implements EmployeeDao {
	
	public List<EmployeeBean> getAllEmployeeData() {
		String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
		String sql = "select * from employee_info";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con = DriverManager.getConnection(url);
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ArrayList<EmployeeBean> result = new ArrayList<>();
			
			while(rs.next()) {
//				System.out.println("Id is "+rs.getInt("id"));
//				System.out.println("Name is "+rs.getString("name"));
//				System.out.println("Salary is "+rs.getInt("sal"));
//				System.out.println("Gender is "+rs.getString("gender"));
//				System.out.println("===================");
				
				EmployeeBean bean = new EmployeeBean();
				int id = rs.getInt("id");
				bean.setId(id);
				
				String name = rs.getString("name");
				bean.setName(name);
				
				int sal = rs.getInt("sal");
				bean.setSal(sal);
				
				String gender = rs.getString("gender");
				bean.setGender(gender);
				
				result.add(bean);
				
				
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		finally {
			try {
				if(con!=null) {
					con.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(rs!=null) {
					rs.close();
				}
			}catch (SQLException e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
		
		
		public EmployeeBean searchEmployeeData(int id) {
			
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			String sql = "select * from employee_info where id=?";
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				con = DriverManager.getConnection(url);
				
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					EmployeeBean bean = new EmployeeBean();
					bean.setId(rs.getInt("id"));
					bean.setName(rs.getString("name"));
					bean.setSal(rs.getInt("sal"));
					bean.setGender(rs.getString("gender"));
					return bean;
					
				}else {
					return null;
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		
		}
		

		@Override
		public int insertEmployeeData(EmployeeBean bean) {
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			String sql = "insert into employee_info values(?,?,?,?)";
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bean.getId());
				pstmt.setString(2, bean.getName());
				pstmt.setInt(3, bean.getSal());
				pstmt.setString(4, bean.getGender());
				int count = pstmt.executeUpdate();
				return count;
		}
			catch (Exception e) {
			e.printStackTrace();
		}
			return 0;
		}


		@Override
		public int updateEmployeeBeanData(EmployeeBean bean) {
			
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			String sql = "update employee_info set name =? , sal=?, gender = ? where id = ?";
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bean.getName());
				pstmt.setInt(2,bean.getSal());
				pstmt.setString(3, bean.getGender());
				pstmt.setInt(4, bean.getId());
				int count = pstmt.executeUpdate();
				return count;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
		}


		@Override
		public int deleteEmployeeData(int id) {
			String url = "jdbc:mysql://localhost:3306/ust_ty_db?user=root&password=root";
			String sql = "delete from employee_info where id =?";
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url);
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, id);
				int count = pstmt.executeUpdate();
				return count;
			}catch (Exception e) {
				e.printStackTrace();
			}
			return 0;
		}
		
		
		
	}



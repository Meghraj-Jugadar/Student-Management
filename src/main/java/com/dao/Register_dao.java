package com.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bo.Register_bo;
import com.bo.search_bo;

public class Register_dao {

	public static Connection connect() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management","root","Monu7070");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
	
	public static int insert(Register_bo rb) {
		int status=0;
		try {
			Connection conn=connect();
			String query="insert into std_regist values(?,?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, rb.getStd_id());
			ps.setString(2, rb.getStd_name());
			ps.setString(3, rb.getStd_phone());
			ps.setString(4, rb.getStd_email());
			ps.setString(5, rb.getStd_password());
			
			status=ps.executeUpdate();
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return status;
	}
	
	public static List<Register_bo> search(String std_id){
		List<Register_bo> list=new ArrayList<Register_bo>();
		try {
			Connection conn=connect();
			
			String query="Select * from std_regist where std_id=?";
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, std_id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				Register_bo rb=new Register_bo();
				rb.setStd_id(rs.getString(1));
				rb.setStd_name(rs.getString(2));
				rb.setStd_phone(rs.getString(3));
				rb.setStd_email(rs.getString(4));
				rb.setStd_password(rs.getString(5));
				
				list.add(rb);
			}
			conn.close();
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static List<Register_bo> fetching(){
		List<Register_bo> list=new ArrayList<Register_bo>();
		try {
			Connection conn=connect();
			String query="select * from std_regist";
			
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				Register_bo rb=new Register_bo();
				rb.setStd_id(rs.getString(1));
				rb.setStd_name(rs.getString(2));
				rb.setStd_phone(rs.getString(3));
				rb.setStd_email(rs.getString(4));
				rb.setStd_password(rs.getString(5));
				
				list.add(rb);
			}
			conn.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static void delete(int std_id){
		try {
			Connection con=connect();
			String query="delete from std_regist where std_id=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, std_id);
			
			ps.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void edit(int choice,int std_id,String details) {
		switch (choice) {
		case 1:
			try {
				Connection con=connect();
				String query="update std_regist set std_name=? where std_id=?";
			
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, details);
				ps.setInt(2, std_id);
				
				ps.executeUpdate();
				
				con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case 2:
			try {
				Connection con=connect();
				String query="update std_regist set std_phone=? where std_id=?";
			
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, details);
				ps.setInt(2, std_id);
				
				ps.executeUpdate();
				
				con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case 3:
			try {
				Connection con=connect();
				String query="update std_regist set std_email=? where std_id=?";
			
				PreparedStatement ps=con.prepareStatement(query);
				
				ps.setString(1, details);
				ps.setInt(2, std_id);
				
				ps.executeUpdate();
			
				con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			break;
		case 4:
			try {
				Connection con=connect();
				String query="update std_regist set std_password=? where std_id=?";
			
				PreparedStatement ps=con.prepareStatement(query);
			
				ps.setString(1, details);
				ps.setInt(2, std_id);
				
				ps.executeUpdate();
			
				con.close();
			} 
			catch (Exception e) {
				// TODO: handle exception
			}
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
	}
	public static int login(String userId,String password) {
		int status=0;
		try {
			Connection con=connect();
			String query="select std_password from std_regist where std_phone=?";
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, userId);
			ResultSet rs=ps.executeQuery();
			String pass="";
			while (rs.next()) {
				pass=rs.getString(1);
			}
			if(password.equals(pass)) {
				status=1;
			}
			else {
				status=0;
			}
		}
		catch (Exception e) {
			
		}
		return status;
	}
	
	
	public static void main(String[] args) {
		

	}

}

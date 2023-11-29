package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bo.Teach_Regist_bo;

public class Teach_Regist_dao {

	public static Connection connect() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management","root","Monu7070");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return con;
	}
	
	public static int insert(Teach_Regist_bo trb) {
		int status=0;
		try {
			Connection con=connect();
			String query="insert into teacher_regist values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, trb.getId());
			ps.setString(2, trb.getName());
			ps.setString(3, trb.getEmail());
			ps.setString(4, trb.getPhone());
			ps.setString(5, trb.getAddr());
			ps.setString(6, trb.getPass());
			status=ps.executeUpdate();
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int login(String id,String pass) {
		int status=0;
		String password="";
		int Uid=Integer.parseInt(id);
		try {
			Connection con=connect();
			String query="select teach_pass from teacher_regist where teach_id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, Uid);
			ResultSet rs=ps.executeQuery();
			
			while (rs.next()) {
				password=rs.getString(1);	
			}
			con.close();
			if(password.equals(pass)) {
				status=1;
			}
			else {
				status=0;
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

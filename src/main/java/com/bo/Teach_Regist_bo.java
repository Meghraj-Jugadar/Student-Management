package com.bo;

public class Teach_Regist_bo {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String addr;
	private String pass;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getAddr() {
		return addr;
	}
	public String getPass() {
		return pass;
	}
	public Teach_Regist_bo(int id, String name, String email, String phone, String addr, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.addr = addr;
		this.pass = pass;
	}
	public Teach_Regist_bo() {
		super();
	}
	
}

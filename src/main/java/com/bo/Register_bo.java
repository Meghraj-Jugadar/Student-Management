package com.bo;

public class Register_bo {
	private String std_id;
	private String std_name;
	private String std_phone;
	private String std_email;
	private String std_password;
	public String getStd_id() {
		return std_id;
	}
	public void setStd_id(String std_id) {
		this.std_id = std_id;
	}
	public String getStd_name() {
		return std_name;
	}
	public void setStd_name(String std_name) {
		this.std_name = std_name;
	}
	public String getStd_phone() {
		return std_phone;
	}
	public void setStd_phone(String std_phone) {
		this.std_phone = std_phone;
	}
	public String getStd_email() {
		return std_email;
	}
	public void setStd_email(String std_email) {
		this.std_email = std_email;
	}
	public String getStd_password() {
		return std_password;
	}
	public void setStd_password(String std_password) {
		this.std_password = std_password;
	}
	public Register_bo(String std_id, String std_name, String std_phone, String std_email, String std_password) {
		super();
		this.std_id = std_id;
		this.std_name = std_name;
		this.std_phone = std_phone;
		this.std_email = std_email;
		this.std_password = std_password;
	}
	public Register_bo() {
		super();
	}
	
}

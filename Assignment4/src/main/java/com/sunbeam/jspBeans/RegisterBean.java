package com.sunbeam.jspBeans;

import java.sql.Date;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class RegisterBean {

	String fname;
	String lname;
	String email;
	String password;
	String date;
	int status;
	String role;
	int count;
	
	
	

	public RegisterBean() {
		status=0;
		role="voter";
	}
	
	
	
	

	public String getFname() {
		return fname;
	}





	public void setFname(String fname) {
		this.fname = fname;
	}





	public String getLname() {
		return lname;
	}





	public void setLname(String lname) {
		this.lname = lname;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public int getStatus() {
		return status;
	}





	public void setStatus(int status) {
		this.status = status;
	}





	public String getRole() {
		return role;
	}





	public void setRole(String role) {
		this.role = role;
	}





	public int getCount() {
		return count;
	}





	public void setCount(int count) {
		this.count = count;
	}





	public void registerUser()
	{
		 Date DOB = Date.valueOf(date);
		
		try(UserDao userdao= new UserDaoImpl())
		{
			User user=new User(0,fname,lname,email,password,DOB,status,role);
			 count=userdao.save(user);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
		
		
	}
	
	
	
}

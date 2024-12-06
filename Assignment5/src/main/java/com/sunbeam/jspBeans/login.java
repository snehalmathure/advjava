package com.sunbeam.jspBeans;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class login {
	
	String email;
	String password;
	User user;
	
	


	public login()
	{
		
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
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	public void login()
	{
		
		
		try (UserDao userdao=new UserDaoImpl()){
			
			User dbuser=userdao.findByEmail(email);
			if(dbuser!=null && dbuser.getPassword().equals(this.password))
			{
				this.user=dbuser;
			}
			else
			{
				this.user=null;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

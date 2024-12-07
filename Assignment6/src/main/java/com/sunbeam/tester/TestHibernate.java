package com.sunbeam.tester;

import org.hibernate.SessionFactory;
import static com.sunbeam.utils.HibernateUtils.getSessionFactory;
public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			try(SessionFactory sf =getSessionFactory())
			{
				System.out.println("Hibernate Up n running");
			}
			catch(RuntimeException e)
			{
				e.printStackTrace();
			}
	}

	
}

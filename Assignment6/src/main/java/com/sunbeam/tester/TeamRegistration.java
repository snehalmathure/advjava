package com.sunbeam.tester;

import org.hibernate.SessionFactory;

import com.sunbeam.Dao.TeamsDao;
import com.sunbeam.Dao.TeamsDaoImpl;
import com.sunbeam.entities.Teams;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

public class TeamRegistration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in))
		{
			TeamsDao teamsdao = new TeamsDaoImpl();
			
			System.out.println("Enter Team details - String name, "
					+ "String abbreviation, String owner, int maxPlayerAge, "
					+ "double battingAvg, int wicketTaken,\r\n"
					);
			
			Teams team = new Teams(sc.next(),sc.next(),sc.next(),sc.nextInt(),sc.nextDouble(),sc.nextInt());
			
			System.out.println(teamsdao.addTeam(team));
			
			
		}
		catch(RuntimeException e)
		{
			e.printStackTrace();
		}

	}

}

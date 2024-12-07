package com.sunbeam.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.Serializable;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import com.sunbeam.entities.Teams;

public class TeamsDaoImpl implements TeamsDao {
	
	
	
	

	@Override
	public String addTeam(Teams team) {
		// TODO Auto-generated method stub
		String msg="Team Registration Failed...";
		Session session= getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			Serializable teamId = session.save(team);
			tx.commit();
			msg="Team Registration Done!!! Team Id - "+teamId;
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		
		return null;
	}

}

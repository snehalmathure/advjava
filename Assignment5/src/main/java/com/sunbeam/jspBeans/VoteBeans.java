package com.sunbeam.jspBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBeans {

	private int candId;
	private int userId;
	private boolean success;
	
	
	
	public VoteBeans()
	{
		
	}
	
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	public void vote()
	{
		this.success=false;
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			int count=candao.incrVote(this.candId);
			if(count==1)
			{
				try(UserDao userdao = new UserDaoImpl())
				{
					User user= userdao.findById(userId);
					if(user!=null)
					{
						user.setStatus(1);
						count=userdao.update(user);
						if(count==1)
						{
							this.success=true;
						}
					}
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
}

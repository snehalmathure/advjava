package com.sunbeam.jspBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class deleteCandBean {
	
	private int candId;
	private int count;
	
	
	public deleteCandBean()
	{
		
	}


	

	public int getCandId() {
		return candId;
	}




	public void setCandId(int candId) {
		this.candId = candId;
	}




	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}
	
	public void deleteCand()
	{
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			count = candao.deleteById(candId);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}

}

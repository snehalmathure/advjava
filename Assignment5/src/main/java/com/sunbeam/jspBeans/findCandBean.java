package com.sunbeam.jspBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class findCandBean {
	
	private int candId;
	private Candidate cand;
	
	
	public findCandBean()
	{
		
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}
	
	

	

	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}

	
	
	public void findCandidate()
	{
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			this.cand= candao.findById(candId)	;	
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	

}

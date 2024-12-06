package com.sunbeam.jspBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class updateCandBean {

	private int candId;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	public updateCandBean()
	{
		
	}
	
	
	
	public int getCandId() {
		return candId;
	}



	public void setCandId(int candId) {
		this.candId = candId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getParty() {
		return party;
	}



	public void setParty(String party) {
		this.party = party;
	}



	public int getVotes() {
		return votes;
	}



	public void setVotes(int votes) {
		this.votes = votes;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public void updateCand()
	{
		
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			Candidate Cand = new Candidate(candId,name,party,votes);
			count=candao.update(Cand);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

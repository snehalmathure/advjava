package com.sunbeam.jspBeans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class registerCandidateBean {
	
	
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	
	public registerCandidateBean()
	{
		votes=0;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public void addCandidate()
	{
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			Candidate cand= new Candidate(id,name,party,votes);
			count= candao.save(cand);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}

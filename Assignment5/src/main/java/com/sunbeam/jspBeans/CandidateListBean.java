package com.sunbeam.jspBeans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidateListBean {
	
	private List<Candidate> candList;
	
	public CandidateListBean()
	{
		candList=new ArrayList<>();
	}
	
	
	
	
	
	
	public List<Candidate> getCandList() {
		return candList;
	}






	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}






	public void displayCandidates()
	{
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			candList= candao.findAll();		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}

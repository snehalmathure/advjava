package com.sunbeam.assign01.entities;

public class Marks {
	
	private double marks;
	private String sub;
	
	
	public Marks()
	{
		
	}
	
	public Marks(String sub,double marks) {
		super();
		this.marks = marks;
		this.sub = sub;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	@Override
	public String toString() {
		return "Marks [marks=" + marks + ", sub=" + sub + "]";
	}
	
	
	

}

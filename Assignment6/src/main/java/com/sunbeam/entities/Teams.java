package com.sunbeam.entities;

import javax.persistence.*;

@Entity
@Table(name="teams")
public class Teams {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long teamId;
	
	@Column(length= 100)
	private String name;
	
	@Column(length= 10, unique=true)
	private String abbreviation;
	
	@Column(length= 20, nullable=false)
	private String owner;
	
	@Column(name="max_player_age")
	private int maxPlayerAge;
	
	@Column(name = "batting_avg")
	private double battingAvg;
	
	@Column(name = "wickets_taken")
	private int wicketTaken;
	
	public Teams()
	{
		
	}
	
	public Teams(String name, String abbreviation, String owner, int maxPlayerAge, double battingAvg,
			int wicketTaken) {
		
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = maxPlayerAge;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int maxPlayerAge) {
		this.maxPlayerAge = maxPlayerAge;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketTaken() {
		return wicketTaken;
	}

	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketTaken=" + wicketTaken
				+ "]";
	}
	
	
	
	
	

}

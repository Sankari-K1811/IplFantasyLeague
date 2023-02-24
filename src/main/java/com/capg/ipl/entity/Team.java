package com.capg.ipl.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="team")
public class Team {
	 @Id
     @GeneratedValue(strategy=GenerationType.IDENTITY)
     @Column(name="team_id")
     private long teamId;
     
     @Column(name="teamname")
     private String teamName;
     
     @Column(name="captain")
     private String captain;
     
     @Column(name="matchesplayed")
     private int matchesPlayed;
     
     @Column(name="matcheswon")
     private int matchesWon;
     
     @Column(name="matchesdrawn")
     private int matchesDrawn;
     
     @Column(name="matcheslost")
     private int matchesLost;
     
     @OneToMany
     @JsonIgnore
     private List<BiddingDetails> biddingDetails;
     
   
     
     
     

	public Team() {
      super();
	}

	public Team(long teamId, String teamname, String captain, int matchesPlayed,int matchesWon,int matchesLost,int matchesDrawn,List<BiddingDetails> biddingDetails) {
		super();
		this.teamId = teamId;
		this.teamName = teamname;
		this.captain = captain;
		this.matchesPlayed = matchesPlayed;
		this.matchesWon = matchesWon;
		this.matchesLost = matchesLost;
		this.matchesDrawn = matchesDrawn;
		this.biddingDetails = biddingDetails;
	}

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamname) {
		this.teamName = teamname;
	}

	public String getCaptain() {
		return captain;
	}

	public void setCaptain(String captain) {
		this.captain = captain;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(int matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public int getMatchesWon() {
		return matchesWon;
	}

	public void setMatchesWon(int matchesWon) {
		this.matchesWon = matchesWon;
	}

	public int getMatchesDrawn() {
		return matchesDrawn;
	}

	public void setMatchesDrawn(int matchesDrawn) {
		this.matchesDrawn = matchesDrawn;
	}

	public int getMatchesLost() {
		return matchesLost;
	}

	public void setMatchesLost(int matchesLost) {
		this.matchesLost = matchesLost;
	}
	public void setBiddingDetails(List<BiddingDetails> biddingDetails){
		this.biddingDetails = biddingDetails;
	}
	public List<BiddingDetails> getBiddingDetails(){
		return this.biddingDetails;
	}
	
	

	@Override
	public String toString() {
		return "Team [teamId=" + teamId + ", teamName=" + teamName + ", captain=" + captain + ", matchesPlayed="
				+ matchesPlayed + ", matchesWon=" + matchesWon + ", matchesDrawn=" + matchesDrawn + ", matchesLost="
				+ matchesLost +  "]";
	}

	
     
    

}

package com.capg.ipl.entity;

import javax.persistence.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="bidding_details")

public class BiddingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bidding_id")
	private long biddingId;
	
	@ManyToOne
	@JoinColumn(name="bidder_id")
	@JsonIgnoreProperties({"userName", "password","biddingDetails"})
	private Bidder bidder;

	
	@OneToOne
	@JoinColumn(name="match_id")
	@JsonIgnoreProperties({"teamOne", "teamTwo","date","time","place","status","result","team"})
	private MatchDetails matchDetails;
	
	@ManyToOne
	@JoinColumn(name="team_id")
	@JsonIgnoreProperties({"captain", "matchesPlayed","matchesWon","matchesDrawn","matchesLost"})
	private Team team;
	
	public BiddingDetails() {
		super();
	}
    
	
	public BiddingDetails(long biddingId,Bidder bidder, MatchDetails matchDetails, Team team) {
		super();
		this.biddingId = biddingId;
		this.bidder = bidder;
		this.matchDetails = matchDetails;
		this.team = team;
	}
	
    

	public long getBiddingId() {
		return biddingId;
	}


	public void setBiddingId(long biddingId) {
		this.biddingId = biddingId;
	}


	public Bidder getBidder() {
		return bidder;
	}


	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}


	public MatchDetails getMatchDetails() {
		return matchDetails;
	}


	public void setMatchDetails(MatchDetails matchDetails) {
		this.matchDetails = matchDetails;
	}


	public Team getTeam() {
		return team;
	}


	public void setTeam(Team team) {
		this.team = team;
	}
    

	@Override
	public String toString() {
		return "BiddingDetails [biddingId=" + biddingId + ", bidderId=" + bidder + ", matchId=" + matchDetails + ", teamId=" + team + "]";
	}
	
	
	

}

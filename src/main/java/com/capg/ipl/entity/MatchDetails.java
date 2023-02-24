package com.capg.ipl.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;




@Entity
@Table(name="match_details")

public class MatchDetails {
	
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="match_id")
	   private long matchId;
	   
	   @OneToOne
	   @JoinColumn(name="team_one_id",referencedColumnName = "team_id")
	   @JsonIgnoreProperties({"teamName","captain", "matchesPlayed","matchesWon","matchesDrawn","matchesLost"})
	   private Team teamOne;
	   
	   @OneToOne
	   @JoinColumn(name="team_two_id",referencedColumnName = "team_id")
	   @JsonIgnoreProperties({"teamName","captain", "matchesPlayed","matchesWon","matchesDrawn","matchesLost"})
	   private Team teamTwo;
	   
	   @Column(name="date")
	   private LocalDate date;
	   
	   @Column(name="time")
	   private LocalTime time;
	   
	   
	   @Column(name="place")
	   private String place;
	   
	   @Column(name="status")
	   private String status;
	   
	   @Column(name="result")
	   private long result;

	public MatchDetails() {
		super();
	}

	public MatchDetails(long matchId, Team teamOne, Team teamTwo, LocalDate date,LocalTime time,String place,String status,long result) {
		this.matchId = matchId;
		this.teamOne = teamOne;
		this.teamTwo = teamTwo;
		this.date = date;
		this.time = time;
		this.place = place;
		this.status = status;
		this.result = result;
	}

	public long getMatchId() {
		return matchId;
	}

	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}

	public void setTeamOne(Team teamOne) {
		this.teamOne = teamOne;
	}
	public Team getTeamOne() {
		return teamOne;
	}
	
	public Team getTeamTwo() {
		return teamTwo;
	}

	public void setTeamTwo(Team teamTwo) {
		this.teamTwo = teamTwo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}


	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getResult() {
		return result;
	}
	public void setResult(long result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "MatchDetails [matchId=" + matchId + ", teamOne=" + teamOne + ", teamTwo=" + ", date=" + date
				+ ", time=" + time +  ", place=" + place + ", status=" + ",result=" + "]";
	}
	   
	
	   
}

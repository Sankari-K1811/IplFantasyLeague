package com.capg.ipl.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="bidder")

public class Bidder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="bidder_id")
	private long bidderId;
	
	@Column(name="bidder_name")
	private String bidderName;
	
	@Column(name="username")
	private String userName;
	
	
	@Column(name="password")
	private String password;
	
	@Column(name="mobile_no")
	private long mobileNo;
	
	@Column(name="points")
	private int points;
	
	@JsonIgnore
	@OneToMany(mappedBy = "bidder")
	private List<BiddingDetails> biddingDetails;
	
    
	public Bidder() {
		super();
	}

	public Bidder(long bidderId, String userName, String password, long mobileNo, int points,String bidderName,List<BiddingDetails> biddingDetails) {
		super();
		this.bidderId = bidderId;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.points = points;
		this.bidderName = bidderName;
		this.biddingDetails = biddingDetails;
	}

	public String getBidderName() {
		return bidderName;
	}

	public void setBidderName(String bidderName) {
		this.bidderName = bidderName;
	}

	public long getBidderId() {
		return bidderId;
	}

	public void setBidderId(long bidderId) {
		this.bidderId = bidderId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
    
	
	public List<BiddingDetails> getBiddingDetails() {
		return biddingDetails;
	}

	public void setBiddingDetails(List<BiddingDetails> biddingDetails) {
		this.biddingDetails = biddingDetails;
	}

	@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidderName=" +bidderName+ ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo  +", biddingDetails= " + biddingDetails +", points=" + points + "]";
	}
	
	
	
	
	
	
	

}

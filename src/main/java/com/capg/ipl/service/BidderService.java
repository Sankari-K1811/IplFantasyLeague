package com.capg.ipl.service;

import java.util.List;

import com.capg.ipl.entity.Bidder;
import com.capg.ipl.entity.BiddingDetails;
import com.capg.ipl.entity.MatchDetails;
import com.capg.ipl.exception.BidAlreadyExistException;
import com.capg.ipl.exception.BidNotFoundException;
import com.capg.ipl.exception.MatchAlreadyInProgressException;
import com.capg.ipl.exception.MatchNotFoundException;
import com.capg.ipl.exception.MatchNotStartedException;
import com.capg.ipl.exception.TeamNotFoundException;
import com.capg.ipl.exception.UserAlreadyExistException;
import com.capg.ipl.exception.UserNotFoundException;

public interface BidderService {
	
	public Bidder registerBidder(Bidder bidder) throws UserAlreadyExistException; //san
	public String bidderLogin(Bidder bidder) throws UserNotFoundException; //san
	
	public List<MatchDetails> viewAllMatches() throws MatchNotFoundException; //sha
	public BiddingDetails addBid(BiddingDetails biddingDetails) throws MatchAlreadyInProgressException,MatchNotFoundException,BidAlreadyExistException;//fat
	public void updateBid(long bidderId,long matchId,long teamId) throws BidNotFoundException,MatchAlreadyInProgressException,TeamNotFoundException;//sha
	
	public int viewPoints(long bidderId) throws UserNotFoundException;//ale
	public void deleteBid(long biddingId) throws BidNotFoundException,MatchAlreadyInProgressException;//nishi
    public String getResult(long matchId) throws MatchNotFoundException,MatchNotStartedException;//ale
}

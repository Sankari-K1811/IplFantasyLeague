package com.capg.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.capg.ipl.service.BidderService;

@RestController
@RequestMapping("/bidder")
public class BidderController {
	
	@Autowired
	private BidderService bidderService;
	
	@PostMapping("/register")
	public Bidder registerBidder(@RequestBody Bidder bidder) throws UserAlreadyExistException {
		return this.bidderService.registerBidder(bidder);
	}
	
	
	
	@PostMapping("/login")
	public String bidderLogin(@RequestBody Bidder bidder) throws UserNotFoundException{
		return this.bidderService.bidderLogin(bidder);
	}
	
	@GetMapping("/all matches")
	public List<MatchDetails> viewAllMatches() throws MatchNotFoundException {
		return this.bidderService.viewAllMatches();
	}
	
	@PostMapping("/bidding")
	public BiddingDetails addBid(@RequestBody BiddingDetails biddingDetails) throws MatchNotFoundException,BidAlreadyExistException, MatchAlreadyInProgressException{
		return this.bidderService.addBid(biddingDetails);
		
	}
	
    
	@PutMapping("/updateBid/{bidderId}/{matchId}/{teamId}")
	public ResponseEntity<String> updateBid(@PathVariable long bidderId,@PathVariable long matchId, @PathVariable long teamId) throws BidNotFoundException,MatchAlreadyInProgressException,TeamNotFoundException{
		this.bidderService.updateBid(bidderId,matchId, teamId);
		return new ResponseEntity<>("Bid Updated Successfully",HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/deleteBid/{biddingId}")
	public ResponseEntity<String> deleteBid(@PathVariable long biddingId) throws BidNotFoundException, MatchAlreadyInProgressException{
		this.bidderService.deleteBid(biddingId);
		return new ResponseEntity<>("Bid Deleted Successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/result/{matchId}")
	public String getResult(@PathVariable long matchId) throws MatchNotFoundException, MatchNotStartedException{
		return this.bidderService.getResult(matchId);
	} 
	
	@GetMapping("/points/{bidderId}")
	public int getPoints(@PathVariable long bidderId) throws UserNotFoundException {
		return this.bidderService.viewPoints(bidderId);
	}
	

}

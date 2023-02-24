package com.capg.ipl.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ipl.entity.Bidder;
import com.capg.ipl.entity.BiddingDetails;
import com.capg.ipl.entity.MatchDetails;
import com.capg.ipl.entity.Team;
import com.capg.ipl.exception.BidAlreadyExistException;
import com.capg.ipl.exception.BidNotFoundException;
import com.capg.ipl.exception.MatchAlreadyInProgressException;
import com.capg.ipl.exception.MatchNotFoundException;
import com.capg.ipl.exception.MatchNotStartedException;
import com.capg.ipl.exception.TeamNotFoundException;
import com.capg.ipl.exception.UserAlreadyExistException;
import com.capg.ipl.exception.UserNotFoundException;
import com.capg.ipl.repository.BidderRepository;
import com.capg.ipl.repository.BiddingRepository;
import com.capg.ipl.repository.MatchRepository;
import com.capg.ipl.repository.TeamRepository;

@Service
public class BidderServiceImpl implements BidderService{
	
	@Autowired
	private BidderRepository bidderRepo;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private BiddingRepository biddingRepo;
	

	@Override
	public Bidder registerBidder(Bidder bidder) throws UserAlreadyExistException{
		if(bidderRepo.findByUserNameAndBidderName(bidder.getUserName(), bidder.getBidderName()).isEmpty()) {
			return bidderRepo.save(bidder);
			
		}
		throw new UserAlreadyExistException();
	    
		
	}

	

	@Override
	public String bidderLogin(Bidder bidder) throws UserNotFoundException{
		if(bidderRepo.userExist(bidder.getUserName(),bidder.getPassword()).isEmpty()) {
			throw new UserNotFoundException();
		}
		else {
			return "Login successful";
		}
	}

	@Override
	public int viewPoints(long bidderId) throws UserNotFoundException {
		Bidder bidder = bidderRepo.getOne(bidderId);
		if(!(bidderRepo.existsById(bidderId))) {
			throw new UserNotFoundException();
		}
		return bidder.getPoints();
	}



	@Override
	public void deleteBid(long biddingId) throws BidNotFoundException,MatchAlreadyInProgressException{
		BiddingDetails bd = biddingRepo.getOne(biddingId);
		if(!(biddingRepo.existsById(biddingId))) {
			throw new BidNotFoundException();
			
		}
		else if(bd.getMatchDetails().getResult()!=0){
			throw new MatchAlreadyInProgressException();
		}
		biddingRepo.delete(bd);
		
		
	}

    @Override
	public List<MatchDetails> viewAllMatches()throws MatchNotFoundException {
    	if(matchRepo.findAll().isEmpty()) {
    		throw new MatchNotFoundException();
    	}
		return matchRepo.findAll();
	}



	@Override
	public BiddingDetails addBid(BiddingDetails biddingDetails) throws MatchNotFoundException,BidAlreadyExistException,MatchAlreadyInProgressException {	
		if(!(biddingRepo.findByMatchDetailsAndBidder(biddingDetails.getMatchDetails(),biddingDetails.getBidder()).isEmpty())) {
			throw new BidAlreadyExistException();
		}
		else if(!(matchRepo.existsById(biddingDetails.getMatchDetails().getMatchId()))) {
			throw new MatchNotFoundException();
		}
		MatchDetails md = matchRepo.findById(biddingDetails.getMatchDetails().getMatchId()).get();
		if(md.getResult()!=0) {
			throw new MatchAlreadyInProgressException();
		}
		return biddingRepo.save(biddingDetails);
    }

    @Override
	public void updateBid(long bidderId,long matchId,long teamId) throws BidNotFoundException,MatchAlreadyInProgressException,TeamNotFoundException {
		MatchDetails md = matchRepo.getOne(matchId);
		Bidder b = bidderRepo.getOne(bidderId);
		Team team = teamRepo.getOne(teamId);
		List<BiddingDetails> bd = biddingRepo.findByMatchDetailsAndBidder(md, b);
		if(bd.isEmpty()) {
			throw new BidNotFoundException();
		}
		else if(md.getResult()!=0) {
			throw new MatchAlreadyInProgressException();
		}
//		else if(md.getTeamOne().getTeamId()!=teamId || md.getTeamTwo().getTeamId()!=teamId) {
//			throw new TeamNotFoundException();
//		}
		else {
			for(BiddingDetails bid:bd) {
				if(bid.getMatchDetails().getMatchId()==matchId && bid.getBidder().getBidderId()==bidderId) {
					bid.setTeam(team);
					biddingRepo.save(bid);
				}
			}
		}
	}

    @Override
	public String getResult(long matchId) throws MatchNotFoundException,MatchNotStartedException{
		if(matchRepo.existsById(matchId)) {
			MatchDetails md = matchRepo.findById(matchId).get();
			if(md.getResult()!=0) {
				Team team = teamRepo.findById(md.getResult()).get();
				return team.getTeamName();
			}
			throw new MatchNotStartedException();
		}
		else {
			throw new MatchNotFoundException();
		}
	}
    


}

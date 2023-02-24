package com.capg.ipl.service;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ipl.entity.Admin;
import com.capg.ipl.entity.Bidder;
import com.capg.ipl.entity.BiddingDetails;
import com.capg.ipl.entity.MatchDetails;
import com.capg.ipl.entity.Team;
import com.capg.ipl.exception.BidderNotFoundException;
import com.capg.ipl.exception.BiddingNotStartedException;
import com.capg.ipl.exception.InvalidAdminException;
import com.capg.ipl.exception.MatchAlreadyExistsException;
import com.capg.ipl.exception.MatchAlreadyInProgressException;
import com.capg.ipl.exception.MatchNotFoundException;
import com.capg.ipl.exception.TeamAlreadyExistException;
import com.capg.ipl.exception.TeamNotFoundException;
import com.capg.ipl.repository.AdminRepository;
import com.capg.ipl.repository.BidderRepository;
import com.capg.ipl.repository.BiddingRepository;
import com.capg.ipl.repository.MatchRepository;
import com.capg.ipl.repository.TeamRepository;


@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private TeamRepository teamRepo;
	
	@Autowired
	private MatchRepository matchRepo;
	
	@Autowired
	private BiddingRepository biddingRepo;
	
	@Autowired
	private BidderRepository bidderRepo;
    
	@Override
	public Admin registerAdmin(Admin admin) {
		return this.adminRepo.save(admin);
	}
	
	@Override
	public String loginAdmin(Admin admin) throws InvalidAdminException{
		if(adminRepo.findAdmin(admin.getUserName(), admin.getPassword()).isEmpty()) {
			
			throw new InvalidAdminException("Invalid Credentials");
		}
		
		return "Login Successful";
	}

	@Override
	public MatchDetails addMatchDetails(MatchDetails matchDetails) throws MatchAlreadyExistsException {
		if(matchRepo.findByDateAndTime(matchDetails.getDate(),matchDetails.getTime()).isEmpty()) {
			return matchRepo.save(matchDetails);
		}
		throw new MatchAlreadyExistsException();
		
		
	}

	@Override
	public Team addTeam(Team team) throws TeamAlreadyExistException{
		if(teamRepo.findByTeamName(team.getTeamName())==null) {
               return teamRepo.save(team);
		}
		else {
			throw new TeamAlreadyExistException();
		}
	}

	@Override
	public void updateMatch(long matchId,MatchDetails matchDetails) throws MatchNotFoundException,MatchAlreadyInProgressException {
		if(matchRepo.existsById(matchId)) {
			MatchDetails md = matchRepo.getOne(matchId);
			if(md.getResult()==0) {
				md.setDate(matchDetails.getDate());
				md.setTime(matchDetails.getTime());
				md.setPlace(matchDetails.getPlace());
				matchRepo.save(md);	
				
			}
			throw new MatchAlreadyInProgressException();
			
		}
		throw new MatchNotFoundException();
		
	}

	@Override
	public void deleteMatchById(long matchId) throws MatchNotFoundException,MatchAlreadyInProgressException{
		if(matchRepo.existsById(matchId)) {
			MatchDetails md = matchRepo.findById(matchId).get();
			 if(md.getResult()!=0) {
			    throw new MatchAlreadyInProgressException();
			 }
			 else
				  matchRepo.delete(md);
		     
	   }
		else {
			throw new MatchNotFoundException();
		}
		
		
	
	}
	public List<Bidder> getAllBidders() throws BiddingNotStartedException{
		
			Iterable<Bidder> bd = bidderRepo.findAll();
			List<Bidder> biddingDetails = new ArrayList<>();
			bd.forEach(bidders->{
				Bidder b = new Bidder();
				b.setBidderId(bidders.getBidderId());
			    b.setBidderName(bidders.getBidderName());
			    b.setMobileNo(bidders.getMobileNo());
			    biddingDetails.add(b);
			});
		if(bidderRepo.findAll().isEmpty()) {
		    throw new BiddingNotStartedException();
		}
		return biddingDetails;
			
	}

	@Override
	public void updateScore(long bidderId) throws BidderNotFoundException {
		if(bidderRepo.existsById(bidderId)) {
			Bidder b = bidderRepo.findById(bidderId).get();
			b.setPoints(b.getPoints()+1);
			bidderRepo.save(b);
		}
		else {
			throw new BidderNotFoundException();
		}
		
		
	}

	@Override
	public void declareTeamResult(long matchId,long teamId) throws MatchNotFoundException{
		if(matchRepo.existsById(matchId)) {
			MatchDetails md = matchRepo.getOne(matchId);
			md.setResult(teamId);
			md.setStatus("Completed");
			Team teamWon = teamRepo.findById(teamId).get();
			teamWon.setMatchesWon(teamWon.getMatchesWon()+1);
			teamWon.setMatchesPlayed(teamWon.getMatchesPlayed()+1);
			if(md.getTeamOne().getTeamId()
					!=teamId) {
				Team teamLost = md.getTeamOne();
				teamLost.setMatchesLost(teamLost.getMatchesLost()+1);
				teamLost.setMatchesPlayed(teamLost.getMatchesPlayed()+1);
				teamRepo.save(teamLost);
			}
			else {
				Team teamLost = md.getTeamTwo();
				teamLost.setMatchesLost(teamLost.getMatchesLost()+1);
				teamLost.setMatchesPlayed(teamLost.getMatchesPlayed()+1);
				teamRepo.save(teamLost);
			}
			teamRepo.save(teamWon);
			matchRepo.save(md);
//			List<Bidder> bidders = bidderRepo.findByMatchId(matchId);
//			for(Bidder b:bidders) {
//				if(((BiddingDetails) b.getBiddingDetails()).getTeam().getTeamId()==teamId) {
//					int point = b.getPoints()+1;
//					b.setPoints(point);
//					bidderRepo.save(b);
//				}
//			}
		}
		else {
			throw new MatchNotFoundException();
		}
		
	}

	@Override
	public void deleteTeam(long teamId) throws TeamNotFoundException{
		Team team = teamRepo.findByTeamId(teamId);
		if(team==null) {
			throw new TeamNotFoundException("Team does not exist");
		}
		else {
			teamRepo.delete(team);
		}
		
	}
}

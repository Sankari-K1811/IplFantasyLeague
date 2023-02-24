package com.capg.ipl.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

@Service
public interface AdminService {
	
	public String loginAdmin(Admin admin) throws InvalidAdminException;//san
	public Admin registerAdmin(Admin admin);//san
	
	public MatchDetails addMatchDetails(MatchDetails matchDetails) throws MatchAlreadyExistsException; //nishi
	public Team addTeam(Team team) throws TeamAlreadyExistException;//sahmmi
	
	public void updateMatch(long matchId,MatchDetails matchDetails) throws MatchNotFoundException,MatchAlreadyInProgressException;//ale
	public void deleteMatchById(long matchId) throws MatchNotFoundException,MatchAlreadyInProgressException;      //sha
	
	public List<Bidder> getAllBidders() throws BiddingNotStartedException;  //ni
	public void updateScore(long bidderId) throws BidderNotFoundException; //fathi
	public void declareTeamResult(long matchId,long teamId) throws MatchNotFoundException; //fathi
	//public List<BiddingDetails> declareBidderResult(long matchId) throws MatchAlreadyInProgressException, MatchNotFoundException;
	
	public void deleteTeam(long teamId) throws TeamNotFoundException; //ale
	
}

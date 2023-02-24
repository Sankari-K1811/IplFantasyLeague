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

import com.capg.ipl.entity.Admin;
import com.capg.ipl.entity.Bidder;
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
import com.capg.ipl.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService ;
	
	@PostMapping("/login")
	public String loginAdmin(@RequestBody Admin admin) throws InvalidAdminException {
		return this.adminService.loginAdmin(admin);
	}
	
	@PostMapping("/register")
	public Admin registerAdmin(@RequestBody Admin admin) {
		return this.adminService.registerAdmin(admin);
	}
	
	@PostMapping("/team")
    public ResponseEntity<String> addTeam(@RequestBody Team team) throws TeamAlreadyExistException {
    	 this.adminService.addTeam(team);
    	 return new ResponseEntity<>("Team added Successfully",HttpStatus.OK);
    }
	
	@DeleteMapping("/team/{teamId}")
	public ResponseEntity<String> deleteTeam(@PathVariable long teamId) throws TeamNotFoundException{
           this.adminService.deleteTeam(teamId);
           return new ResponseEntity<>("Team Deleted Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/match")
	public ResponseEntity<String> addMatchDetails(@RequestBody MatchDetails matchDetails) throws MatchAlreadyExistsException {
		this.adminService.addMatchDetails(matchDetails);
	    return new ResponseEntity<>("Match added",HttpStatus.OK);
		
	}
	
	@PutMapping("/match/{matchId}") //
	public ResponseEntity<String> updateMatch(@PathVariable long matchId,MatchDetails matchDetails) throws MatchNotFoundException,MatchAlreadyInProgressException {
		this.adminService.updateMatch(matchId,matchDetails);
		System.out.println("Controller:"+matchDetails);
		return new ResponseEntity<>("Match Updated Successfully",HttpStatus.OK);
		
	}
	
	@GetMapping("/bidders") 
	public List<Bidder>getAllBidders() throws BiddingNotStartedException{
		return this.adminService.getAllBidders();
	}
	
	@PutMapping("/score/{bidderId}") 
	public ResponseEntity<String> updateScore(@PathVariable Long bidderId) throws BidderNotFoundException{
		this.adminService.updateScore(bidderId);
		return new ResponseEntity<>("Score Updated Successfully",HttpStatus.OK);
	}
	
	@PutMapping("/result/{matchId}/{teamId}")
	public ResponseEntity<String> declareResult(@PathVariable Long matchId,@PathVariable Long teamId) throws MatchNotFoundException{
		this.adminService.declareTeamResult(matchId, teamId);
	   return new ResponseEntity<>("Result Declared",HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/match/{matchId}") 
	public ResponseEntity<String> deleteMatchById(@PathVariable Long matchId) throws MatchNotFoundException,MatchAlreadyInProgressException{
		this.adminService.deleteMatchById(matchId);
		return new ResponseEntity<>("Match Deleted",HttpStatus.OK);
	}
	
	
}

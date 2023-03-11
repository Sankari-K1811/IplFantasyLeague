package com.capg.ipl.IplFantasyLeague;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 

import com.capg.ipl.controller.AdminController;
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
@RunWith(MockitoJUnitRunner.class)
public class AdminControllerTest {
@Mock
private AdminService adminService;
@InjectMocks
private AdminController adminController;

 

@Test
public void testRegisterAdmin(){
    Admin admin = new Admin();
    when(adminService.registerAdmin(any(Admin.class))).thenReturn(admin);
    Admin result = adminController.registerAdmin(admin);
    assertEquals(admin,result);
}
@Test
public void testLoginAdmin() throws InvalidAdminException {
    Admin admin = new Admin();
    admin.setUsername("admin");
    admin.setPassword("password");
    when(adminService.loginAdmin(admin)).thenReturn("Successful Login");
    assertEquals("Successful Login", adminController.loginAdmin(admin));
}
@Test
public void testAddTeam() throws TeamAlreadyExistException {
    Team team = new Team();
    when(adminService.addTeam(any(Team.class))).thenReturn(team);
    ResponseEntity<String> result = adminController.addTeam(team);
    assertEquals("Team added Successfully", result.getBody());
}
@Test
public void testAddMatchDetails() throws MatchAlreadyExistsException {
    MatchDetails matchDetails = new MatchDetails();
    when(adminService.addMatchDetails(any(MatchDetails.class))).thenReturn(matchDetails);
    ResponseEntity<String> result = adminController.addMatchDetails(matchDetails);
    assertEquals("Match added", result.getBody());
}
@Test
public void testDeclareResult() throws MatchNotFoundException {
    Long matchId = 1L;
    Long teamId = 2L;
    doNothing().when(adminService).declareTeamResult(matchId, teamId);
    ResponseEntity<String> response = adminController.declareResult(matchId, teamId);
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals("Result Declared", response.getBody());
}
@Test
public void testUpdateScore() throws BidderNotFoundException {
  Bidder bidder = new Bidder();
  Long bidderId=1L;
  bidder.setBidderId(1L);
  doNothing().when(adminService).updateScore(1L);
  ResponseEntity<String> result = adminController.updateScore(bidderId);
  assertEquals("Score Updated Successfully", result.getBody());
}
@Test
public void testUpdateMatch() throws MatchNotFoundException,MatchAlreadyInProgressException {
      MatchDetails matchDetails=new MatchDetails();
      Long matchId=1L;
      doNothing().when(adminService).updateMatch(1L,matchDetails);
      ResponseEntity<String> result = adminController.updateMatch(matchId,matchDetails);
      assertEquals("Match Updated Successfully", result.getBody());
    }
@Test
public void testDeleteTeam() throws TeamNotFoundException{
    long teamId=1L;
    doNothing().when(adminService).deleteTeam(teamId);
    ResponseEntity<String> response=adminController.deleteTeam(teamId);
    assertEquals(HttpStatus.OK,response.getStatusCode());
    assertEquals("Team Deleted Successfully",response.getBody());
}
@Test
public void testDeleteMatchById() throws MatchNotFoundException, MatchAlreadyInProgressException{
    long matchId=1L;
    doNothing().when(adminService).deleteMatchById(matchId);
    ResponseEntity<String> response=adminController.deleteMatchById(matchId);
    assertEquals(HttpStatus.OK,response.getStatusCode());
    assertEquals("Match Deleted",response.getBody());
}
@Test
public void testGetAllBidders() throws BiddingNotStartedException{
	List<Bidder> bidders=new ArrayList<>();
	bidders.add(new Bidder(1L,"John","Saans",879797997,3,null,null));
	bidders.add(new Bidder(2L,"Sankari","Sak",898998989,1,null,null));
	when(adminService.getAllBidders()).thenReturn(bidders);
	List<Bidder> result=adminController.getAllBidders();
	assertEquals(bidders,result);
	
	
}
}
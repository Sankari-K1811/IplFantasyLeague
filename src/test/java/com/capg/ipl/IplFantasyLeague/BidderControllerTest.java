package com.capg.ipl.IplFantasyLeague;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.capg.ipl.controller.BidderController;
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
import com.capg.ipl.service.BidderService;
@RunWith(MockitoJUnitRunner.class)
public class BidderControllerTest {
	
	@Mock
    private BidderService bidderService;
	@InjectMocks
    private BidderController bidderController;
	@Test
    public void testRegisterBidder() throws UserAlreadyExistException {
        Bidder bidder = new Bidder();
        when(bidderService.registerBidder(any(Bidder.class))).thenReturn(bidder);
        Bidder result = bidderController.registerBidder(bidder);
        assertEquals(bidder,result);
    }
	@Test
    public void testBidderLogin() throws UserNotFoundException {
        Bidder bidder = new Bidder();
        when(bidderService.bidderLogin(any(Bidder.class))).thenReturn("Login successful");
        String result = bidderController.bidderLogin(bidder);
        assertEquals("Login successful", result);
    }
	@Test
	public void testAddBid() throws MatchNotFoundException,BidAlreadyExistException,MatchAlreadyInProgressException {
		BiddingDetails biddingDetails = new BiddingDetails();
		when(bidderService.addBid(any(BiddingDetails.class))).thenReturn(biddingDetails);
		BiddingDetails result = bidderController.addBid(biddingDetails);
		assertEquals(biddingDetails, result);
	}
	@Test
	public void testUpdateBid() throws BidNotFoundException,MatchAlreadyInProgressException {
		doNothing().when(bidderService).updateBid(anyLong(),anyLong(), anyLong());
		ResponseEntity<String> result = bidderController.updateBid(1L, 2L, 3L);
	    assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
	}
	@Test
	public void testDeleteBid() throws BidNotFoundException,MatchAlreadyInProgressException {
		doNothing().when(bidderService).deleteBid(anyLong());
		ResponseEntity<String> result = bidderController.deleteBid(1L);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	@Test
	public void testViewAllMatches() throws MatchNotFoundException{
		List<MatchDetails> matchDetails=new ArrayList<>();
		matchDetails.add(new MatchDetails());
		matchDetails.add(new MatchDetails());
		when(bidderService.viewAllMatches()).thenReturn(matchDetails);
		List<MatchDetails> result=bidderController.viewAllMatches();
		assertEquals(matchDetails,result);
	}
	@Test
	public void testViewPoints() throws UserNotFoundException{
		Bidder bidder=new Bidder();
		bidder.setBidderId(1L);
		Mockito.when(bidderService.viewPoints(bidder.getBidderId())).thenReturn(100);
		int result=bidderController.viewPoints(bidder.getBidderId());
		assertEquals(100, result);;
		Mockito.verify(bidderService).viewPoints(bidder.getBidderId());
	}
	@Test
	public void testGetResult() throws MatchNotFoundException,MatchNotStartedException{
		MatchDetails matchDetails=new MatchDetails();
		matchDetails.setMatchId(1L);
		Mockito.when(bidderService.getResult(matchDetails.getMatchId())).thenReturn("csk");
		String result=bidderController.getResult(matchDetails.getMatchId());
		assertEquals("csk", result);;
		Mockito.verify(bidderService).getResult(matchDetails.getMatchId());
	}
	@Test
    public void TestGetTeamById() throws Exception {
       Team team = new Team();
       team.setTeamId(1L);
       team.setTeamName("Test Team");
       when(bidderService.getTeamById(1L)).thenReturn(team);
       Team result = bidderController.getTeamById(1L);
       assertEquals(team.getTeamId(), result.getTeamId());
       assertEquals(team.getTeamName(), result.getTeamName());
    }
}
//package com.capg.ipl.IplFantasyLeague;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import com.capg.ipl.controller.BidderController;
//import com.capg.ipl.entity.Bidder;
//import com.capg.ipl.entity.BiddingDetails;
//import com.capg.ipl.service.BidderService;
//@RunWith(MockitoJUnitRunner.class)
//public class BidderControllerTest {
//	
//	@Mock
//    private BidderService bidderService;
//	@InjectMocks
//    private BidderController bidderController;
//	@Test
//    public void testRegisterBidder() throws Exception {
//        Bidder bidder = new Bidder();
//        when(bidderService.registerBidder(any(Bidder.class))).thenReturn(bidder);
//        Bidder result = bidderController.registerBidder(bidder);
//        assertEquals(bidder,result);
//    }
//	@Test
//    public void testBidderLogin() throws Exception {
//        Bidder bidder = new Bidder();
//        when(bidderService.bidderLogin(any(Bidder.class))).thenReturn("Success");
//        String result = bidderController.bidderLogin(bidder);
//        assertEquals("Success", result);
//    }
//	@Test
//	public void testAddBid() throws Exception {
//		BiddingDetails biddingDetails = new BiddingDetails();
//		when(bidderService.addBid(any(BiddingDetails.class))).thenReturn(biddingDetails);
//		BiddingDetails result = bidderController.addBid(biddingDetails);
//		assertEquals(biddingDetails, result);
//	}
//	@Test
//	public void testUpdateBid() throws Exception {
//		doNothing().when(bidderService).updateBid(anyLong(),anyLong(), anyLong());
//		ResponseEntity<String> result = bidderController.updateBid(1L, 2L, 3L);
//	    assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
//	}
//	@Test
//	public void testDeleteBid() throws Exception {
//		doNothing().when(bidderService).deleteBid(anyLong());
//		ResponseEntity<String> result = bidderController.deleteBid(1L);
//		assertEquals(HttpStatus.OK, result.getStatusCode());
//	}
//}
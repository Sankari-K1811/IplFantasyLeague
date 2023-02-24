package com.capg.ipl.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ipl.entity.Bidder;
import com.capg.ipl.entity.BiddingDetails;
import com.capg.ipl.entity.MatchDetails;



@Repository
public interface BiddingRepository extends JpaRepository<BiddingDetails, Long>{
    
	@Query("select b from BiddingDetails b where b.bidder.bidderId =: bidderId")
	public BiddingDetails findBidderById(@Param (value="bidderId") long bidderId);
	
	@Query("select b from BiddingDetails b where b.matchDetails.matchId =: matchId")
	public BiddingDetails findMatchById(@Param (value="matchId") long matchId);
	
	@Modifying
	@Query("delete BiddingDetails b where b.matchDetails.matchId=:matchId")
	public void deleteMatchById(@Param(value="matchId") long matchId);
	
	public List<BiddingDetails> findByMatchDetailsAndBidder(MatchDetails matchDetails, Bidder bidder);

}

package com.capg.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ipl.entity.Bidder;

@Repository
public interface BidderRepository extends JpaRepository<Bidder, Long>{
	
    public List<Bidder> findByUserNameAndBidderName(String userName,String bidderName);
	
	@Query("select b from Bidder b where b.userName=:username and b.password=:password")
	public List<Bidder> userExist(@Param(value ="username") String userName,@Param(value="password") String password);
	
	@Query("select b from Bidder b where b.bidderName =:  bidderName")
	public List<Bidder> findByName(@Param(value="bidderName") String bidderName);
	
//	@Query("select b from Bidder b where b.biddingDetails.matchDetails.matchId=:matchId")
//	public List<Bidder> findByMatchId(@Param(value="matchId") long matchId);

	public List<Bidder> findByBidderName(String bidderName);
	
}

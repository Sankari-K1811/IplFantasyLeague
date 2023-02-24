package com.capg.ipl.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.ipl.entity.MatchDetails;

@Repository
@Transactional
@javax.transaction.Transactional
public interface MatchRepository extends JpaRepository<MatchDetails, Long>{
	@Query("select m from MatchDetails m where m.teamOne.teamId=:teamId or m.teamTwo.teamId=:teamId")
    public MatchDetails existByTeamId(@Param(value="teamId") long teamId);   
	
	public List<MatchDetails> findByDateAndTime(LocalDate date,LocalTime time);
	
}

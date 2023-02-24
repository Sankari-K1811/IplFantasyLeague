package com.capg.ipl.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ipl.entity.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long>{
	
	@Query("select t from Team t where t.teamName=:teamName")
	public Team findByTeamName(@Param(value="teamName") String teamName);
	
	@Query("select t from Team t where t.teamId=:teamId")
	public Team findByTeamId(@Param(value="teamId") long teamId);

}

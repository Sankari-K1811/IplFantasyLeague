package com.capg.ipl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capg.ipl.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{
    
	@Query("select a from Admin a where a.userName=:username and a.password=:password")
	public List<Admin> findAdmin(@Param (value="username") String userName,@Param(value = "password") String password);
}

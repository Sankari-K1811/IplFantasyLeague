package com.capg.ipl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableJpaRepositories("com.capg.*")
//@ComponentScan("com.capg.*")
//@EntityScan("com.capg.*")
@SpringBootApplication
//@EnableSwagger2
public class IplFantasyLeagueApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplFantasyLeagueApplication.class, args);
	}

}

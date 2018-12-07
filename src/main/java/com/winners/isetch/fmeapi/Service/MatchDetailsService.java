package com.winners.isetch.fmeapi.Service;


import com.winners.isetch.fmeapi.Entity.MatchDetails;
import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Repository.MatchDetailsRepository;
import com.winners.isetch.fmeapi.Repository.MatchRepository;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchDetailsService {

	@Autowired
	private MatchDetailsRepository matchRepository;
	



	public List<MatchDetails> getmatchs() {
		List<MatchDetails> lm = null;
		lm = (List<MatchDetails>) matchRepository.findAll();

			return lm;
		

	}

	public MatchDetails getmatch(int id) {

		return matchRepository.findById(id).get();

	}

	public void addmatch(MatchDetails match) {

		matchRepository.save(match);
	}

	public void editmatch(MatchDetails match, int id){

			matchRepository.deleteById(id);
			matchRepository.save(match);
		
	}

	public void deletematch(int id){

		matchRepository.deleteById(id);
	}
	
	
	
	
	
	public void deleteAllmatchs(){

		matchRepository.deleteAll();
	}

	public List<MatchDetails> getMatchByDate(String date){

		return matchRepository.findByDateEquals(date);
	}
	
	

}

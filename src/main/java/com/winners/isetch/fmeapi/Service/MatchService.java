package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Repository.MatchRepository;

@Service
public class MatchService {

	 @Autowired
	    private MatchRepository matchRepository;

	    public List<Matchee> getmatchs() {
	        List<Matchee> lp=new ArrayList<>();
	        matchRepository.findAll()
	                .forEach(lp::add);
	        return lp;
	    }

	    public Matchee getmatch(int id){
	       
	        return matchRepository.findById(id).get();

	    }

	    public void addmatch(Matchee match){
	        matchRepository.save(match);
	    }

	    public void editmatch(Matchee match, int id) {

	        matchRepository.save(match);
	    }

	    public void deletematch(int id) {

	        matchRepository.deleteById(id);
	    }
	
}

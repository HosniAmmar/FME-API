package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchService;
import com.winners.isetch.fmeapi.exceptionMatch.AddMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionMatch.DeleteMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.EditMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetListMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetMatchByIdException;

@RestController
public class MatchController {

	static final String crossOriginUrl = "http://localhost:4200";
	@Autowired
	private MatchService matchService;

	
	
	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	@RequestMapping("/matchs")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Matchee> getAllmatchs() {
		List<Matchee> lm=null;
		try {
			lm=matchService.getmatchs();
		} catch (GetListMatchException e) {
			System.out.println(e.getMessage());
		}
		return lm;
		
	}

    @RequestMapping("/match/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public Matchee getmatchById(@PathVariable int id) {
		Matchee m=null;	
		try {
				m= matchService.getmatch(id);
			} catch (GetMatchByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return m;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/match")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addmatch(@RequestBody Matchee match) {
		
		try {
			matchService.addmatch(match);
			return true;
		} catch (AddMatchException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/match/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean editmatch(@RequestBody Matchee match, @PathVariable int id) {
		try {
			matchService.editmatch(match, id);
			return true;
		} catch (EditMatchException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/match/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deletematch(@PathVariable int id) {
		try {
			matchService.deletematch(id);
			return true;
		} catch (DeleteMatchException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
       
 
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllMatchs")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean deleteAllmatchs() {
		try {
			matchService.deleteAllmatchs();
			return true;
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}

package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/getListMatchs")
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

	@RequestMapping(method = RequestMethod.POST, value = "/getMatch")
	@CrossOrigin(origins = crossOriginUrl)
	public Matchee getmatchById(@RequestParam int id) {
		Matchee m=null;	
		try {
				m= matchService.getmatch(id);
			} catch (GetMatchByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return m;
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addMatch")
	@CrossOrigin(origins = crossOriginUrl)
	public void addmatch(@RequestBody Matchee match) {
		
		try {
			matchService.addmatch(match);
		} catch (AddMatchException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/editMatch")
	@CrossOrigin(origins = crossOriginUrl)
	public void editmatch(@RequestBody Matchee match, @RequestParam int id) {
		try {
			matchService.editmatch(match, id);
		} catch (EditMatchException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteMatch")
	@CrossOrigin(origins = crossOriginUrl)
	public void deletematch(@RequestParam int id) {
		try {
			matchService.deletematch(id);
		} catch (DeleteMatchException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllMatchs")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllmatchs() {
		try {
			matchService.deleteAllmatchs();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}
}

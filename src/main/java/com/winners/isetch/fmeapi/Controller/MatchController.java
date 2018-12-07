package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchService;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.AddMatchException;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.DeleteAllException;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.DeleteMatchException;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.EditMatchException;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.GetListMatchException;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.GetMatchByIdException;

@RestController
public class MatchController {

	//static final String crossOriginUrl = "http://localhost:8200";
	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private MatchService matchService;

	
	
	public MatchService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchService matchService) {
		this.matchService = matchService;
	}

	@RequestMapping("/match")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
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
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
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
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void addmatch(@RequestBody Matchee match) {
		
		try {
			matchService.addmatch(match);
		} catch (AddMatchException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/match/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void editmatch(@RequestBody Matchee match, @PathVariable int id) {
		try {
			matchService.editmatch(match, id);
		} catch (EditMatchException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/match/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deletematch(@PathVariable int id) {
		try {
			matchService.deletematch(id);
		} catch (DeleteMatchException e) {
			System.out.println(e.getMessage());
		}
	}
	
       
 
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllMatchs")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deleteAllmatchs() {
		try {
			matchService.deleteAllmatchs();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

		@RequestMapping(method = RequestMethod.GET,value="/match/date")
		@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<Matchee> getMatchByDate(@RequestParam("date") String date){
		return this.matchService.getMatchByDate(date);
		}
}

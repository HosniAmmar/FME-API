package com.winners.isetch.fmeapi.Controller;


import com.winners.isetch.fmeapi.Entity.MatchDetails;
import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchDetailsService;
import com.winners.isetch.fmeapi.Service.MatchService;
import com.winners.isetch.fmeapi.exceptions.exceptionMatch.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MatchDetailsController {

	//static final String crossOriginUrl = "http://localhost:8200";
	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private MatchDetailsService matchService;

	
	
	public MatchDetailsService getMatchService() {
		return matchService;
	}

	public void setMatchService(MatchDetailsService matchService) {
		this.matchService = matchService;
	}

	@RequestMapping("/matchD")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<MatchDetails> getAllmatchs() {
		List<MatchDetails> lm=null;
			lm=matchService.getmatchs();

		return lm;
		
	}

    @RequestMapping("/matchD/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public MatchDetails getmatchById(@PathVariable int id) {
		MatchDetails m=null;
				m= matchService.getmatch(id);


		return m;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/matchD")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void addmatch(@RequestBody MatchDetails match) {
		

			matchService.addmatch(match);

	}

    @RequestMapping(method = RequestMethod.PUT,value="/matchD/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void editmatch(@RequestBody MatchDetails match, @PathVariable int id) {

			matchService.editmatch(match, id);

	}

    @RequestMapping(method = RequestMethod.DELETE,value="/matchD/{id}")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deletematch(@PathVariable int id) {
			matchService.deletematch(id);

	}
	
       
 
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllMatchsD")
	@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public void deleteAllmatchs() {

			matchService.deleteAllmatchs();

	}

		@RequestMapping(method = RequestMethod.GET,value="/matchD/date")
		@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
	public List<MatchDetails> getMatchByDate(@RequestParam("date") String date){
		return this.matchService.getMatchByDate(date);
		}
}

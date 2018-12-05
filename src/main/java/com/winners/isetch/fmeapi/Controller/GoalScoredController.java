package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.winners.isetch.fmeapi.Entity.GoalScored;
import com.winners.isetch.fmeapi.Service.GoalScoredService;
import com.winners.isetch.fmeapi.exceptionGoalScored.AddGoalScoredException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByMatchException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerException;
import com.winners.isetch.fmeapi.exceptionGoalScored.GetGoalScoredByPlayerInMatchException;


@RestController
public class GoalScoredController {

	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private GoalScoredService goalScoredService;

	


		
    public GoalScoredService getGoalScoredService() {
		return goalScoredService;
	}

	public void setGoalScoredService(GoalScoredService goalScoredService) {
		this.goalScoredService = goalScoredService;
	}

	@RequestMapping(method = RequestMethod.GET,value="/MatchGoalScored/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsInMatch(@PathVariable int id) {
    	 List<GoalScored> lgs=null;
		try {
			lgs = goalScoredService.getGoalScoredsInMatch(id);
		} catch (GetGoalScoredByMatchException e) {
			System.out.println(e.getMessage());
		}
    	 return lgs;
    	
   	}
   
    @RequestMapping(method = RequestMethod.GET,value="/PlayerGoalScored/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsByPlayer(@PathVariable int id) {
    	 List<GoalScored> lgs=null;
		try {
			lgs = goalScoredService.getGoalScoredsByPlayer(id);
		} catch (GetGoalScoredByPlayerException e) {
			System.out.println(e.getMessage());

		}
    	 return lgs;
    	
   	}
    
    @RequestMapping(method = RequestMethod.GET,value="/MatchPlayerGoalScored/{idP}/{idM}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsByPlayerInMatch(@PathVariable("idP") int idP,@PathVariable("idM") int idM) {
    	 List<GoalScored> lgs=null;
		try {
			lgs = goalScoredService.getGoalScoredsByPlayerInMatch(idP,idM);
		} catch (GetGoalScoredByPlayerInMatchException e) {
			System.out.println(e.getMessage());

		}
    	 return lgs;
    	
   	}
    
    @RequestMapping(method = RequestMethod.POST,value="/GoalScored")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addGoalScored(@RequestBody GoalScored goalScored) {
		
			 try {
				goalScoredService.addGoalScored(goalScored);
				return true;
			} catch (AddGoalScoredException e) {
				return false;
			}
	
	}
    
    
}

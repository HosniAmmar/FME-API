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


@RestController
public class GoalScoredController {

	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private GoalScoredService goalScoredService;

	


		
    @RequestMapping(method = RequestMethod.GET,value="/MatchGoalScored/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsInMatch(@PathVariable int id) {
    	 List<GoalScored>lgs=goalScoredService.getGoalScoredsInMatch(id);
    	 return lgs;
    	
   	}
   
    @RequestMapping(method = RequestMethod.GET,value="/PlayerGoalScored/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsByPlayer(@PathVariable int id) {
    	 List<GoalScored>lgs=goalScoredService.getGoalScoredsByPlayer(id);
    	 return lgs;
    	
   	}
    
    @RequestMapping(method = RequestMethod.GET,value="/MatchPlayerGoalScored/{idP}/{idM}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<GoalScored> getGoalScoredsByPlayerInMatch(@PathVariable("idP") int idP,@PathVariable("idM") int idM) {
    	 List<GoalScored>lgs=goalScoredService.getGoalScoredsByPlayerInMatch(idP,idM);
    	 return lgs;
    	
   	}
    
    @RequestMapping(method = RequestMethod.POST,value="/GoalScored")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addmatch(@RequestBody GoalScored goalScored) {
		
			return goalScoredService.addGoalScored(goalScored);
	
	}
    
    
}

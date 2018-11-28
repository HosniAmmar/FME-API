package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.winners.isetch.fmeapi.Entity.Warning;
import com.winners.isetch.fmeapi.Service.WarningService;


@RestController
public class WarningController {

	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private WarningService warningService;

	


		
    @RequestMapping(method = RequestMethod.GET,value="/MatchWarning/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Warning> getWarningsInMatch(@PathVariable int id) {
    	 List<Warning>lw=warningService.getWarningsInMatch(id);
    	 return lw;
    	
   	}
   
    @RequestMapping(method = RequestMethod.GET,value="/PlayerWarning/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Warning> getWarningsByPlayer(@PathVariable int id) {
    	 List<Warning>lw=warningService.getWarningsByPlayer(id);
    	 return lw;
    	
   	}
    
    @RequestMapping(method = RequestMethod.GET,value="/MatchPlayerWarning/{idP,idM}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Warning> getWarningsByPlayerInMatch(@PathVariable int idP,@PathVariable int idM) {
    	 List<Warning>lw=warningService.getWarningsByPlayerInMatch(idP,idM);
    	 return lw;
    	
   	}
    
    @RequestMapping(method = RequestMethod.POST,value="/Warning")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addWarning(@RequestBody Warning warning) {
		
			return warningService.addWarning(warning);
	
	}
    
    
}

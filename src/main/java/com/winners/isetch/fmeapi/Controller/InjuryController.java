package com.winners.isetch.fmeapi.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.winners.isetch.fmeapi.Entity.Injury;
import com.winners.isetch.fmeapi.Service.InjuryService;
import com.winners.isetch.fmeapi.exceptionInjury.AddInjuryException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByMatchException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerInMatchException;


@RestController
public class InjuryController {

	static final String crossOriginUrl = "http://localhost:4200";

	@Autowired
	private InjuryService injuryService;

	


		
    public InjuryService getInjuryService() {
		return injuryService;
	}

	public void setInjuryService(InjuryService injuryService) {
		this.injuryService = injuryService;
	}

	@RequestMapping(method = RequestMethod.GET,value="/MatchInjury/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Injury> getInjurysInMatch(@PathVariable int id) {
    	 List<Injury> li=null;
		try {
			li = injuryService.getInjurysInMatch(id);
		} catch (GetInjuryByMatchException e) {
			System.out.println(e.getMessage());

		}
    	 return li;
    	
   	}
   
    @RequestMapping(method = RequestMethod.GET,value="/PlayerInjury/{id}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Injury> getInjurysByPlayer(@PathVariable int id) {
    	 List<Injury> li=null;
		try {
			li = injuryService.getInjurysByPlayer(id);
		} catch (GetInjuryByPlayerException e) {
			System.out.println(e.getMessage());

		}
    	 return li;
    	
   	}
    
    @RequestMapping(method = RequestMethod.GET,value="/MatchPlayerInjury/{idP,idM}")
   	@CrossOrigin(origins = crossOriginUrl)
   	public List<Injury> getInjurysByPlayerInMatch(@PathVariable int idP,@PathVariable int idM) {
    	 List<Injury> li=null;
		try {
			li = injuryService.getInjurysByPlayerInMatch(idP,idM);
		} catch (GetInjuryByPlayerInMatchException e) {
			System.out.println(e.getMessage());

		}
    	 return li;
    	
   	}
    
    @RequestMapping(method = RequestMethod.POST,value="/Injury")
	@CrossOrigin(origins = crossOriginUrl)
	public boolean addInjury(@RequestBody Injury injury) {
		
			try {
				injuryService.addInjury(injury);
				return true;
			} catch (AddInjuryException e) {
				return false;
			}
	
	}
    
    
}

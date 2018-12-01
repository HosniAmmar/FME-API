package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.President;
import com.winners.isetch.fmeapi.Service.PresidentService;
import com.winners.isetch.fmeapi.exceptionPresident.AddPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionPresident.DeletePresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.EditPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetListPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetPresidentByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresidentController {
	static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private PresidentService presidentService;


    @RequestMapping("/president")
	@CrossOrigin(origins = crossOriginUrl)
	public List<President> getAllPresidents() {
		List<President> lp=null;
		try {
			lp=presidentService.getPresidents();
		} catch (GetListPresidentException e) {
			System.out.println(e.getMessage());
		}
		return lp;
		
	}

    @RequestMapping("/president/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public President getPresidentById(@PathVariable int id) {
		President p=null;	
		try {
				p= presidentService.getPresident(id);
			} catch (GetPresidentByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return p;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/president")
	@CrossOrigin(origins = crossOriginUrl)
	public void addPresident(@RequestBody President president) throws AddPresidentException {
    	presidentService.addPresident(president);
//		try {
//			presidentService.addPresident(president);
//		} catch (AddPresidentException e) {
//			System.out.println(e.getMessage());
//		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/president/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void editPresident(@RequestBody President president, @PathVariable int id) {
		try {
			presidentService.editPresident(president, id);
		} catch (EditPresidentException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/president/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void deletePresident(@PathVariable int id) {
		try {
			presidentService.deletePresident(id);
		} catch (DeletePresidentException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllPresidents")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllPresidents() {
		try {
			presidentService.deleteAllPresidents();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public PresidentService getPresidentService() {
		return presidentService;
	}

	public void setPresidentService(PresidentService presidentService) {
		this.presidentService = presidentService;
	}

}
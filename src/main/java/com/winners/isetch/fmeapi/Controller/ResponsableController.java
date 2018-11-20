package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Service.ResponsableService;
import com.winners.isetch.fmeapi.exceptionResponsable.AddResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionResponsable.DeleteResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.EditResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetListResponsableException;
import com.winners.isetch.fmeapi.exceptionResponsable.GetResponsableByIdException;

@RestController
public class ResponsableController {
	static final String crossOriginUrl="http://localhost:4200";
	@Autowired
    private ResponsableService responsableService;
	
	
	
	@RequestMapping("/responsable")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Responsable> getAllResponsables() {
		List<Responsable> lrs=null;
		try {
			lrs=responsableService.getResponsables();
		} catch (GetListResponsableException e) {
			System.out.println(e.getMessage());
		}
		return lrs;
		
	}

    @RequestMapping("/responsable/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public Responsable getResponsableById(@PathVariable int id) {
		Responsable rs=null;	
		try {
				rs= responsableService.getResponsable(id);
			} catch (GetResponsableByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return rs;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/responsable")
	@CrossOrigin(origins = crossOriginUrl)
	public void addResponsable(@RequestBody Responsable responsable) {
		
		try {
			responsableService.addResponsable(responsable);
		} catch (AddResponsableException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/responsable/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void editResponsable(@RequestBody Responsable responsable, @PathVariable int id) {
		try {
			responsableService.editResponsable(responsable, id);
		} catch (EditResponsableException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/responsable/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteResponsable(@PathVariable int id) {
		try {
			responsableService.deleteResponsable(id);
		} catch (DeleteResponsableException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllResponsables")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllResponsables() {
		try {
			responsableService.deleteAllResponsables();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResponsableService getResponsableService() {
		return responsableService;
	}

	public void setResponsableService(ResponsableService responsableService) {
		this.responsableService = responsableService;
	}
	
}

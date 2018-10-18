package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Responsable;
import com.winners.isetch.fmeapi.Service.ResponsableService;

@RestController
public class ResponsableController {
	static final String crossOriginUrl="http://localhost:4200";
	@Autowired
    private ResponsableService responsableService;
	
	
	
	@RequestMapping("/responsable")
    @CrossOrigin(origins = crossOriginUrl)
    public List<Responsable> getAllResponsable(){
       return responsableService.getResponsables();
    }

    @RequestMapping("/responsable/{id}")
    @CrossOrigin(origins = crossOriginUrl)
    public Responsable getResponsableById(@PathVariable int id){
        return responsableService.getResponsable(id);
    }

    @RequestMapping(method = RequestMethod.POST,value="/responsable")
    public void addReferee(@RequestBody Responsable responsable){
    	responsableService.addResponsable(responsable);
    }
    
    @RequestMapping(method = RequestMethod.PUT,value="/responsable/{id}")
        public void editReferee(@RequestBody Responsable responsable,@PathVariable int id){
    	responsableService.editResponsable(responsable,id);
        }
@RequestMapping(method = RequestMethod.DELETE,value="/responsable/{id}")
@CrossOrigin(origins = crossOriginUrl)
public void deleteResponsable(@PathVariable int id){
	responsableService.deleteResponsable(id);
}

	
}

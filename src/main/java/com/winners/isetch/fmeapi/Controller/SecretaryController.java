package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Secretary;
import com.winners.isetch.fmeapi.Service.SecretaryService;
import com.winners.isetch.fmeapi.exceptionSecretary.AddSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionSecretary.DeleteSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.EditSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetListSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetSecretaryByIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SecretaryController {
	static final String crossOriginUrl = "http://localhost:4200";

    @Autowired
    private SecretaryService secretaryService;


    @RequestMapping("/secretary")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Secretary> getAllSecretarys() throws GetListSecretaryException {
		List<Secretary> ls=null;
			ls=secretaryService.getSecretarys();

		return ls;
		
	}

    @RequestMapping("/secretary/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public Secretary getSecretaryById(@PathVariable int id) throws GetSecretaryByIdException {
    	Secretary s=null;	
				s= secretaryService.getSecretary(id);
		return s;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/secretary")
	@CrossOrigin(origins = crossOriginUrl)
	public void addSecretary(@RequestBody Secretary secretary) {
		
		try {
			secretaryService.addSecretary(secretary);
		} catch (AddSecretaryException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/secretary/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void editSecretary(@RequestBody Secretary secretary, @PathVariable int id) {
		try {
			secretaryService.editSecretary(secretary, id);
		} catch (EditSecretaryException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/secretary/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteSecretary(@PathVariable int id) {
		try {
			secretaryService.deleteSecretary(id);
		} catch (DeleteSecretaryException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllSecretarys")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllSecretarys() {
		try {
			secretaryService.deleteAllSecretarys();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public SecretaryService getSecretaryService() {
		return secretaryService;
	}

	public void setSecretaryService(SecretaryService secretaryService) {
		this.secretaryService = secretaryService;
	}

}
package com.winners.isetch.fmeapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.RefereeService;
import com.winners.isetch.fmeapi.exceptionReferee.AddRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionReferee.DeleteRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.EditRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.GetListRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.GetRefereeByIdException;



@RestController
public class RefereeController {
	 static final String crossOriginUrl="http://localhost:4200";
	@Autowired
	private RefereeService refereeService;


	@RequestMapping("/getListReferees")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Referee> getAllReferees() {
		List<Referee> lr=null;
		try {
			lr=refereeService.getReferees();
		} catch (GetListRefereeException e) {
			System.out.println(e.getMessage());
		}
		return lr;
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/getReferee")
	@CrossOrigin(origins = crossOriginUrl)
	public Referee getRefereeById(@RequestParam int id) {
		Referee r=null;	
		try {
				r= refereeService.getReferee(id);
			} catch (GetRefereeByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return r;
		
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addReferee")
	@CrossOrigin(origins = crossOriginUrl)
	public void addReferee(@RequestBody Referee referee) {
		
		try {
			refereeService.addReferee(referee);
		} catch (AddRefereeException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/editReferee")
	@CrossOrigin(origins = crossOriginUrl)
	public void editReferee(@RequestBody Referee referee, @RequestParam int id) {
		try {
			refereeService.editReferee(referee, id);
		} catch (EditRefereeException e) {
			System.out.println(e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteReferee")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteReferee(@RequestParam int id) {
		try {
			refereeService.deleteReferee(id);
		} catch (DeleteRefereeException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllReferees")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllReferees() {
		try {
			refereeService.deleteAllReferees();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public RefereeService getRefereeService() {
		return refereeService;
	}

	public void setRefereeService(RefereeService refereeService) {
		this.refereeService = refereeService;
	}
}

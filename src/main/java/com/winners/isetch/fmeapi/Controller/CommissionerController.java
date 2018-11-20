package com.winners.isetch.fmeapi.Controller;

import com.winners.isetch.fmeapi.Entity.Commissioner;
import com.winners.isetch.fmeapi.Service.CommissionerService;
import com.winners.isetch.fmeapi.exceptionCommissioner.AddCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionCommissioner.DeleteCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.EditCommissionerException;
import com.winners.isetch.fmeapi.exceptionCommissioner.GetCommissionerByIdException;
import com.winners.isetch.fmeapi.exceptionCommissioner.GetListCommissionerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommissionerController {
	static final String crossOriginUrl="http://localhost:4200";
    @Autowired
    private CommissionerService commissionerService;


    @RequestMapping("/commissioner")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Commissioner> getAllCommissioners() {
		List<Commissioner> lc=null;
		try {
			lc=commissionerService.getCommissioners();
		} catch (GetListCommissionerException e) {
			System.out.println(e.getMessage());
		}
		return lc;
		
	}

    @RequestMapping("/commissioner/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public Commissioner getCommissionerById(@PathVariable int id) {
		Commissioner cm=null;	
		try {
				cm= commissionerService.getCommissioner(id);
			} catch (GetCommissionerByIdException e) {
				
				System.out.println(e.getMessage());
			}
		return cm;
		
	}

    @RequestMapping(method = RequestMethod.POST,value="/commissioner")
	@CrossOrigin(origins = crossOriginUrl)
	public void addCommissioner(@RequestBody Commissioner commissioner) {
		
		try {
			commissionerService.addCommissioner(commissioner);
		} catch (AddCommissionerException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.PUT,value="/commissioner/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void editCommissioner(@RequestBody Commissioner commissioner, @PathVariable int id) {
		try {
			commissionerService.editCommissioner(commissioner, id);
		} catch (EditCommissionerException e) {
			System.out.println(e.getMessage());
		}
	}

    @RequestMapping(method = RequestMethod.DELETE,value="/commissioner/{id}")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteCommissioner(@PathVariable int id) {
		try {
			commissionerService.deleteCommissioner(id);
		} catch (DeleteCommissionerException e) {
			System.out.println(e.getMessage());
		}
	}
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteAllCommissioners")
	@CrossOrigin(origins = crossOriginUrl)
	public void deleteAllCommissioners() {
		try {
			commissionerService.deleteAllCommissioners();
		} catch (DeleteAllException e) {
			System.out.println(e.getMessage());
		}
	}

	public CommissionerService getCommissionerService() {
		return commissionerService;
	}

	public void setCommissionerService(CommissionerService commissionerService) {
		this.commissionerService = commissionerService;
	}

}
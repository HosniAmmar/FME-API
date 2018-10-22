package com.winners.isetch.fmeapi.Controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.AccountService;

@RestController
public class AccountController {
	
	 static final String crossOriginUrl="http://localhost:4200";

	@Autowired
	private AccountService accountService;

	
	  @RequestMapping(method = RequestMethod.POST,value = "/login" )
	  @CrossOrigin(origins = crossOriginUrl)
	  public Account loginProcess(@RequestBody Account user) {
		  System.out.println(user.getUserName());
	    Account user2 = accountService.findByUsernameAndPassword(user.getUserName(),user.getPassword());
	    Account ac = new Account();
	    if (null == user2) {
	    	System.out.println("false");
	    	return ac;
	    } 
	    
	    else {
	    	System.out.println(user2.toString());
	    	return user2;

	    }
	 
	  }


	   @RequestMapping("/accounts")
       @CrossOrigin(origins = crossOriginUrl)
       public List<Account> getAllAccounts(){
          return accountService.getAccounts();
       }

	
	
}

package com.winners.isetch.fmeapi.Controller;
import java.util.List;



import org.springframework.beans.factory.annotation.*;

import org.springframework.web.bind.annotation.*;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Service.AccountService;
import com.winners.isetch.fmeapi.exceptionAcount.GetAcountException;
import com.winners.isetch.fmeapi.exceptionAcount.GetAllAcountsException;

@RestController
public class AccountController {
	
	 static final String crossOriginUrl="http://localhost:4200";

	@Autowired
	private AccountService accountService;



@RequestMapping(method = RequestMethod.POST, value = "/login")
	@CrossOrigin(origins = crossOriginUrl)
	public Account login(@RequestBody Account user) {
		Account user1 = null;
		try {
			user1 = accountService.findByUsernameAndPassword(user.getUserName(),user.getPassword());
		} catch (GetAcountException | GetAllAcountsException e) {
			System.out.println(e.getMessage());
		}

		return user1;

	}

	@RequestMapping("/accounts")
	@CrossOrigin(origins = crossOriginUrl)
	public List<Account> getAllAccounts() {
		List<Account> lac = null;
		try {
			lac = accountService.getAccounts();
		} catch (GetAllAcountsException e) {
			System.out.println(e.getMessage());
		}
		return lac;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
}

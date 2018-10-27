package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account findByUsernameAndPassword(String un,String pw) {
        List<Account> la=getAccounts();       
        Account a1 = null;
        for(Account a : la) {
        	if(a.getUserName().equals(un) && a.getPassword().equals(pw) ) {
                a1=a;
        		return a;

        	}
        }
        
		return a1;
	}
	 public List<Account> getAccounts() {
	        List<Account> lp=new ArrayList<>();
	        accountRepository.findAll()
	                .forEach(lp::add);
	        return lp;
	    }
}

package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Entity.Player;
import com.winners.isetch.fmeapi.Repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account findByUsernameAndPassword(String userName,String password) {
        List<Account> la=new ArrayList<>();        
        accountRepository.findAll().forEach(la::add);
        for(Account a : la) {
        	if(a.getUserName()==userName && a.getPassword()==password) {
        		return a;
        	}
        }
        
		return null;
	}
}

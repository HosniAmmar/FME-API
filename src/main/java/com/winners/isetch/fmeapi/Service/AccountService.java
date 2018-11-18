package com.winners.isetch.fmeapi.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Repository.AccountRepository;
import com.winners.isetch.fmeapi.exception.exceptionAcount.*;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	public Account findByUsernameAndPassword(String un, String pw) throws GetAcountException, GetAllAcountsException {
		List<Account> la = getAccounts();
		Account a = null;
		for (Account a1 : la) {
			if (a1.getUserName().equals(un) && a1.getPassword().equals(pw)) {
				a = a1;
			}
		}
		if (a == null)
			throw new GetAcountException("Erreur : User_Name ou Password incorrect !");
		else
		return a;
	}

	public List<Account> getAccounts() throws GetAllAcountsException {
		List<Account> lp = null;
		lp = (List<Account>) accountRepository.findAll();
		if (lp.isEmpty() || lp.equals(null))
			throw new GetAllAcountsException("Erreur : aucun compte trouvé !");
		else {
//	        	lp=new ArrayList<>();
//	        	accountRepository.findAll()
//                .forEach(lp::add);
			return lp;
		}

	}
}

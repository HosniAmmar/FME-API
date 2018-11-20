package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Account;
import com.winners.isetch.fmeapi.Service.AccountService;
import com.winners.isetch.fmeapi.exceptionAcount.GetAcountException;
import com.winners.isetch.fmeapi.exceptionAcount.GetAllAcountsException;

public class AccountControllerTest {

	AccountController accountContoller=new AccountController();
	AccountService accountService =mock(AccountService.class);
	Account account = new Account(111,"med", "123456789", "med med");
	Account account2 = new Account(222,"ali", "123456780", "ali ali");

	@Before
	public void setUp() {
		accountContoller.setAccountService(accountService);
	}


	@Test
	public void testLogin() throws GetAcountException, GetAllAcountsException {
		when(accountService.findByUsernameAndPassword(account.getUserName(),account.getPassword())).thenReturn(account);
		assertEquals(account,accountContoller.login(account.getUserName(),account.getPassword()));
		verify(accountService).findByUsernameAndPassword(account.getUserName(),account.getPassword());
		System.out.println("account valid !! :"+accountContoller.login(account.getUserName(),account.getPassword()));
		System.out.println("\n  "+accountService.findByUsernameAndPassword(account.getUserName(),account.getPassword()).getUserName()+" "+accountService.findByUsernameAndPassword(account.getUserName(),account.getPassword()).getPassword());

		
		when(accountService.findByUsernameAndPassword(account2.getUserName(),account2.getPassword())).thenReturn(account2);
		assertEquals(account2,accountContoller.login(account2.getUserName(),account2.getPassword()));
		verify(accountService).findByUsernameAndPassword(account2.getUserName(),account2.getPassword());
		System.out.println("account2  valid !! : "+accountContoller.login(account2.getUserName(),account2.getPassword()));
		System.out.println("\n  "+accountService.findByUsernameAndPassword(account2.getUserName(),account2.getPassword()).getUserName()+" "+accountService.findByUsernameAndPassword(account2.getUserName(),account2.getPassword()).getPassword());
	}

}

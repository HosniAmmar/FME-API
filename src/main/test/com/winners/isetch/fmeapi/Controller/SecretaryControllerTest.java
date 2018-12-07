package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Secretary;
import com.winners.isetch.fmeapi.Service.SecretaryService;
import com.winners.isetch.fmeapi.exceptionSecretary.AddSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.DeleteSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.EditSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetListSecretaryException;
import com.winners.isetch.fmeapi.exceptionSecretary.GetSecretaryByIdException;

public class SecretaryControllerTest {

	SecretaryController secretaryController=new SecretaryController();
	SecretaryService secretaryService=mock(SecretaryService.class);
	List<Secretary> listS=new ArrayList<>();
	Secretary s1=new Secretary("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1);
	Secretary s2=new Secretary("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2);
	
	@Before
	public void setUp()  {
		secretaryController.setSecretaryService(secretaryService);
		listS.add(s1);
		listS.add(s2);
		
	}

	@Test
	public void testGetAllSecretarys() throws GetListSecretaryException {
		when(secretaryService.getSecretarys()).thenReturn(listS);
		assertEquals(listS, secretaryController.getAllSecretarys());
	}

	@Test
	public void testGetSecretaryById() throws GetSecretaryByIdException {
		when(secretaryService.getSecretary(s1.getId())).thenReturn(s1);
		assertEquals(s1, secretaryController.getSecretaryById(s1.getId()));
	}

	@Test
	public void testAddSecretary() throws AddSecretaryException {
		when(secretaryService.addSecretary(s1)).thenReturn(true);
		assertEquals(true, secretaryController.addSecretary(s1));
	}

	@Test
	public void testEditSecretary() throws EditSecretaryException {
		when(secretaryService.editSecretary(s1,s1.getId())).thenReturn(true);
		assertEquals(true, secretaryController.editSecretary(s1,s1.getId()));

	
	}

	@Test
	public void testDeleteSecretary() throws DeleteSecretaryException {
		when(secretaryService.deleteSecretary(s1.getId())).thenReturn(true);
		assertEquals(true, secretaryController.deleteSecretary(s1.getId()));

	
	}



}

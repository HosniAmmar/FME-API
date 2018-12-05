package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Injury;
import com.winners.isetch.fmeapi.Service.InjuryService;
import com.winners.isetch.fmeapi.exceptionInjury.AddInjuryException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByMatchException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerException;
import com.winners.isetch.fmeapi.exceptionInjury.GetInjuryByPlayerInMatchException;

public class InjuryControllerTest {

	InjuryController injuryController=new InjuryController();
	InjuryService injuryService=mock(InjuryService.class);
	Injury j1=new Injury(1, 1, 1, 10, "type", "infomation");
	Injury j2=new Injury(2, 5, 1, 55, "type", "infomation");
	Injury j3=new Injury(3, 1, 5, 20, "type", "infomation");
	List<Injury>l1=new ArrayList<Injury>();
	List<Injury>l2=new ArrayList<Injury>();
	List<Injury>l3=new ArrayList<Injury>();
	
	
	@Before
	public void setUp()  {
		injuryController.setInjuryService(injuryService);
		l1.add(j1);
		l1.add(j2);
		l2.add(j1);
		l2.add(j3);
		l3.add(j3);
	}

	@Test
	public void testGetInjurysInMatch() throws GetInjuryByMatchException {
		when(injuryService.getInjurysInMatch(1)).thenReturn(l1);
		assertEquals(l1,injuryController.getInjurysInMatch(1));
	}

	@Test
	public void testGetInjurysByPlayer() throws GetInjuryByPlayerException {
		when(injuryService.getInjurysByPlayer(1)).thenReturn(l2);
		assertEquals(l2,injuryController.getInjurysByPlayer(1));
	}

	@Test
	public void testGetInjurysByPlayerInMatch() throws GetInjuryByPlayerInMatchException {
		when(injuryService.getInjurysByPlayerInMatch(1, 5)).thenReturn(l3);
		assertEquals(l3,injuryController.getInjurysByPlayerInMatch(1, 5));	
	}

	@Test
	public void testAddInjury() throws AddInjuryException {
		when(injuryService.addInjury(j1)).thenReturn(true);
		assertEquals(true,injuryController.addInjury(j1));
	}

}

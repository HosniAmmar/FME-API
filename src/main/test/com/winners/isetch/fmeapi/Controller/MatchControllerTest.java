package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchService;
import com.winners.isetch.fmeapi.exceptionMatch.AddMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.DeleteMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.EditMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetListMatchException;
import com.winners.isetch.fmeapi.exceptionMatch.GetMatchByIdException;

public class MatchControllerTest {

	MatchController matchController=new MatchController();
	MatchService matchService=mock(MatchService.class);
	List<Matchee> listM=new ArrayList<>();
	List<Matchee> listM2=new ArrayList<>();
	Matchee m1=new Matchee(1,1,2, "date", "heure","place", 1, 2, 3, 1);
	Matchee m2=new Matchee(2,3,4, "date", "heure", "place",1, 2, 3, 2);
	
	@Before
	public void setUp() {
		matchController.setMatchService(matchService);
		listM.add(m1);
		listM.add(m2);
		listM2.add(m1);
		listM2.add(m2);
	}

	@Test
	public void testGetAllmatchs() throws GetListMatchException {
		when(matchService.getmatchs()).thenReturn(listM);
		assertEquals(listM2,matchController.getAllmatchs());
	}

	@Test
	public void testGetmatchById() throws GetMatchByIdException {
		when(matchService.getmatch(m1.getId())).thenReturn(m1);
		assertEquals(m1,matchController.getmatchById(m1.getId()));
	}

	@Test
	public void testAddmatch() throws AddMatchException {
		when(matchService.addmatch(m1)).thenReturn(true);
		assertEquals(true,matchController.addmatch(m1));
	}

	@Test
	public void testEditmatch() throws EditMatchException {
		when(matchService.editmatch(m1,m1.getId())).thenReturn(true);
		assertEquals(true,matchController.editmatch(m1,m1.getId()));	}

	@Test
	public void testDeletematch() throws DeleteMatchException {
		when(matchService.deletematch(m1.getId())).thenReturn(true);
		assertEquals(true,matchController.deletematch(m1.getId()));	
	}


}

package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Matchee;
import com.winners.isetch.fmeapi.Service.MatchService;
import com.winners.isetch.fmrapi.exceptionMatch.AddMatchException;
import com.winners.isetch.fmrapi.exceptionMatch.DeleteAllException;
import com.winners.isetch.fmrapi.exceptionMatch.DeleteMatchException;
import com.winners.isetch.fmrapi.exceptionMatch.EditMatchException;
import com.winners.isetch.fmrapi.exceptionMatch.GetListMatchException;
import com.winners.isetch.fmrapi.exceptionMatch.GetMatchByIdException;

public class MatchControllerTest {

	MatchController matchController=new MatchController();
	MatchService matchService=mock(MatchService.class);
	List<Matchee> listM=new ArrayList<>();
	List<Matchee> listM2=new ArrayList<>();
	Matchee m1=new Matchee(111, 1, 2, "28/10/2018", "17:00", 122, 133, 144, 155,"Rades" );
	Matchee m2=new Matchee(211, 3, 4, "28/10/2018", "19:00", 222,233, 244, 255,"Rades");
	
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
		verify(matchService).getmatchs();
	}

	@Test
	public void testGetmatchById() throws GetMatchByIdException {
		when(matchService.getmatch(m1.getId())).thenReturn(m1);
		assertEquals(m1,matchController.getmatchById(m1.getId()));
		verify(matchService).getmatch(m1.getId());
	}

	@Test
	public void testAddmatch() throws AddMatchException {
		matchController.addmatch(m1);
		verify(matchService).addmatch(m1);
	}

	@Test
	public void testEditmatch() throws EditMatchException {
		matchController.editmatch(m2,m1.getId());
		verify(matchService).editmatch(m2,m1.getId());
	}

	@Test
	public void testDeletematch() throws DeleteMatchException {
		matchController.deletematch(m1.getId());
		verify(matchService).deletematch(m1.getId());
	}
	@Test
	public void testDeleteAllmatchs() throws DeleteAllException {
		matchController.deleteAllmatchs();
		verify(matchService).deleteAllmatchs();

	}

}

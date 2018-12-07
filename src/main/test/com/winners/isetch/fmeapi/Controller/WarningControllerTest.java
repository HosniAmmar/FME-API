package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Warning;
import com.winners.isetch.fmeapi.Service.WarningService;
import com.winners.isetch.fmeapi.exceptionWarning.AddWarningException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByMatchException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByPlayerException;
import com.winners.isetch.fmeapi.exceptionWarning.GetWarningByPlayerInMatchException;

public class WarningControllerTest {

	WarningController warningController=new WarningController();
	WarningService warningService=mock(WarningService.class);
	Warning w1=new Warning(1, 1, "10", 1, "color", "information");
	Warning w2=new Warning(2, 1, "50", 2, "color", "information");
	Warning w3=new Warning(3, 1, "70", 1, "color", "information");
	List<Warning>l1=new ArrayList<Warning>();
	List<Warning>l2=new ArrayList<Warning>();
	List<Warning>l3=new ArrayList<Warning>();
	
	@Before
	public void setUp()  {
		warningController.setWarningService(warningService);
		l1.add(w1);
		l1.add(w2);
		l1.add(w3);
		l2.add(w1);
		l2.add(w3);
		l3.add(w2);
	}

	@Test
	public void testGetWarningsInMatch() throws GetWarningByMatchException {
		when(warningService.getWarningsInMatch(1)).thenReturn(l1);
		assertEquals(l1,warningController.getWarningsInMatch(1));
	}

	@Test
	public void testGetWarningsByPlayer() throws GetWarningByPlayerException {
		when(warningService.getWarningsByPlayer(1)).thenReturn(l2);
		assertEquals(l2,warningController.getWarningsByPlayer(1));
	}

	@Test
	public void testGetWarningsByPlayerInMatch() throws GetWarningByPlayerInMatchException {
		when(warningService.getWarningsByPlayerInMatch(1, 2)).thenReturn(l3);
		assertEquals(l3,warningController.getWarningsByPlayerInMatch(1, 2));
	}

	@Test
	public void testAddWarning() throws AddWarningException {
		when(warningService.addWarning(w1)).thenReturn(true);
		assertEquals(true,warningController.addWarning(w1));
	}

}

package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.President;
import com.winners.isetch.fmeapi.Service.PresidentService;
import com.winners.isetch.fmeapi.exceptionPresident.AddPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.DeletePresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.EditPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetListPresidentException;
import com.winners.isetch.fmeapi.exceptionPresident.GetPresidentByIdException;

public class PresidentControllerTest {

	PresidentController presidentController=new PresidentController();
	PresidentService presidentService=mock(PresidentService.class);
	List<President> listP1=new ArrayList<>();
	President p1=new President("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1);
	President p2=new President("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2 );
	@Before
	public void setUp()  {
		presidentController.setPresidentService(presidentService);
		
		listP1.add(p1);
		listP1.add(p2);
	}

	@Test
	public void testGetAllPresidents() throws GetListPresidentException {
		when(presidentService.getPresidents()).thenReturn(listP1);
		assertEquals(listP1, presidentController.getAllPresidents());
		verify(presidentService).getPresidents();
	}

	@Test
	public void testGetPresidentById() throws GetPresidentByIdException {
		when(presidentService.getPresident(p1.getId())).thenReturn(p1);
		assertEquals(p1, presidentController.getPresidentById(p1.getId()));
		verify(presidentService).getPresident(p1.getId());
	}

	@Test
	public void testAddPresident() throws AddPresidentException {
		presidentController.addPresident(p1);
		verify(presidentService).addPresident(p1);
	}

	@Test
	public void testEditPresident() throws EditPresidentException {
		presidentController.editPresident(p1,p1.getId());
		verify(presidentService).editPresident(p1,p1.getId());
	}

	@Test
	public void testDeletePresident() throws DeletePresidentException {
		presidentController.deletePresident(p1.getId());
		verify(presidentService).deletePresident(p1.getId());
	}

//	@Test
//	public void testDeleteAllPresidents() {
//		fail("Not yet implemented");
//	}
//


}

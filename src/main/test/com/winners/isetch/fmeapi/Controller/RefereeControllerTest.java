package com.winners.isetch.fmeapi.Controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.winners.isetch.fmeapi.Entity.Referee;
import com.winners.isetch.fmeapi.Service.RefereeService;
import com.winners.isetch.fmeapi.exceptionReferee.AddRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.DeleteAllException;
import com.winners.isetch.fmeapi.exceptionReferee.DeleteRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.EditRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.GetListRefereeException;
import com.winners.isetch.fmeapi.exceptionReferee.GetRefereeByIdException;

public class RefereeControllerTest {

	RefereeController refereeController=new RefereeController();
	RefereeService refereeService=mock(RefereeService.class);
	List<Referee> l=new ArrayList<>();
	List<Referee> l2=new ArrayList<>();
	Referee referee = new Referee("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 1, 1);
	Referee referee2 = new Referee("firstName", "lastName", "phone", "natIdNum", "address", "mailAddress", 1.70, 70, "birthdate", "nationality", "photoUrl", "region", "city", "numpasseport", "comment", 2, 2);

	@Before
	public void setUp(){
		refereeController.setRefereeService(refereeService);
		l.add(referee);
		l.add(referee2);
		l2.add(referee);
		l2.add(referee2);
	}

	@Test
	public void testGetAllReferees() throws GetListRefereeException {
		when(refereeService.getReferees()).thenReturn(l);
		assertEquals(l2, refereeController.getAllReferees());
		verify(refereeService).getReferees();
	}

	@Test
	public void testGetRefereeById() throws GetRefereeByIdException {
		when(refereeService.getReferee(referee.getId())).thenReturn(referee);
		assertEquals(referee, refereeController.getRefereeById(referee.getId()));
		verify(refereeService).getReferee(referee.getId());
	}

	@Test
	public void testAddReferee() throws AddRefereeException {
		refereeController.addReferee(referee);
		verify(refereeService).addReferee(referee);
		
	}

	@Test
	public void testEditReferee() throws EditRefereeException {
		refereeController.editReferee(referee,referee.getId());
		verify(refereeService).editReferee(referee, referee.getId());
	}

	@Test
	public void testDeleteReferee() throws DeleteRefereeException {
		refereeController.deleteReferee(referee.getId());
		verify(refereeService).deleteReferee(referee.getId());
	}
	
	@Test
	public void testDeleteAllReferees() throws DeleteAllException {
		refereeController.deleteAllReferees();
		verify(refereeService).deleteAllReferees();
	}

}
